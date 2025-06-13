package com.example.tp8_h071231087;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp8_h071231087.data.db.NoteHelper;
import com.example.tp8_h071231087.data.mapping.MappingHelper;
import com.example.tp8_h071231087.data.model.Note;
import com.example.tp8_h071231087.databinding.ActivityMainBinding;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private RecyclerView rvNotes;
    private NoteAdapter noteAdapter;
    private NoteHelper notesHelper;
    private final int REQUEST_ADD = 100;
    private final int REQUEST_UPDATE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView searchIcon = binding.svNotes.findViewById(
                binding.svNotes.getContext().getResources()
                        .getIdentifier("android:id/search_mag_icon", null, null)
        );

        if (searchIcon != null) {
            searchIcon.setColorFilter(ContextCompat.getColor(this, R.color.textWhite), PorterDuff.Mode.SRC_IN);
        }

        rvNotes = binding.rvNote;
        noteAdapter = new NoteAdapter(this);
        rvNotes.setAdapter(noteAdapter);

        notesHelper = NoteHelper.getInstance(getApplicationContext());

        binding.svNotes.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.isEmpty()) {
                    loadNotes();
                    return true;
                } else {
                    searchNotes(newText);
                    return true;
                }
            }
        });

        loadNotes();
    }

    private void loadNotes() {
        new LoadNotesAsync(this, notes -> {
            ArrayList<Note> modifiedNotes = new ArrayList<>();

            // Tambahkan dummy item di posisi 0 untuk "Add Note"
            Note dummyAddButton = new Note();
            dummyAddButton.setId(-1);
            modifiedNotes.add(dummyAddButton);

            // Tambahkan semua note asli setelahnya
            if (notes != null && notes.size() > 0) {
                binding.tvNoNote.setVisibility(View.GONE);
                modifiedNotes.addAll(notes);
            } else {
                binding.tvNoNote.setVisibility(View.VISIBLE);
            }

            noteAdapter.setNotes(modifiedNotes);
        }).execute();
    }

    private void searchNotes(String keyword) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            notesHelper.open();
            Cursor cursor = notesHelper.searchByTitle(keyword);
            ArrayList<Note> filteredNotes = MappingHelper.mapCursorToArrayList(cursor);
            notesHelper.close();

            handler.post(() -> {
                ArrayList<Note> modifiedNotes = new ArrayList<>();

                Note dummyAddButton = new Note();
                dummyAddButton.setId(-1);
                modifiedNotes.add(dummyAddButton);

                if (filteredNotes.size() > 0) {
                    modifiedNotes.addAll(filteredNotes);
                }

                noteAdapter.setNotes(modifiedNotes);
            });
        });
    }

    @Override
    protected void onActivityResult(int requestcode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestcode, resultCode, data);
        if (requestcode == REQUEST_ADD) {
            if (resultCode == NoteFormActivity.RESULT_ADD) {
                loadNotes();
            }
        } else if (requestcode == REQUEST_UPDATE) {
            if (resultCode == NoteFormActivity.RESULT_UPDATE) {
                loadNotes();
            } else if (resultCode == NoteFormActivity.RESULT_DELETE) {
                loadNotes();
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (notesHelper != null) {
            notesHelper.close();
        }
    }

    private static class LoadNotesAsync {
        private final WeakReference<Context> weakContext;
        private final WeakReference<LoadNotesCallBack> weakCallback;

        private LoadNotesAsync(Context context, LoadNotesCallBack callback) {
            weakContext = new WeakReference<>(context);
            weakCallback = new WeakReference<>(callback);
        }

        void execute() {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Handler handler = new Handler(Looper.getMainLooper());

            executor.execute(() -> {
                Context context = weakContext.get();

                if (context != null) {
                    NoteHelper noteHelper = NoteHelper.getInstance(context);
                    noteHelper.open();

                    Cursor notesCursor = noteHelper.queryAll();
                    ArrayList<Note> notes = MappingHelper.mapCursorToArrayList(notesCursor);

                    noteHelper.close();

                    handler.post(() -> {
                        LoadNotesCallBack callBack = weakCallback.get();
                        if (callBack != null) {
                            callBack.postExecute(notes);
                        }

                    });
                }
            });
        }
    }

    interface LoadNotesCallBack {
        void postExecute(ArrayList<Note> notes);
    }
}