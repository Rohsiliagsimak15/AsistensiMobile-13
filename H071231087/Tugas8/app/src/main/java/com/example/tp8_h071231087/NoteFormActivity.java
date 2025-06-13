package com.example.tp8_h071231087;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tp8_h071231087.data.db.DatabaseContract;
import com.example.tp8_h071231087.data.db.NoteHelper;
import com.example.tp8_h071231087.data.model.Note;
import com.example.tp8_h071231087.databinding.ActivityNoteFormBinding;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;


public class NoteFormActivity extends AppCompatActivity {
    private ActivityNoteFormBinding binding;
    public static final String EXTRA_NOTE = "extra_student";
    public static final int RESULT_ADD = 101;
    public static final int RESULT_UPDATE = 201;
    public static final int RESULT_DELETE = 301;
    public static final int REQUEST_UPDATE = 200;
    private NoteHelper noteHelper;
    private Note note;
    private boolean isEdit = false;
    private final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityNoteFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        noteHelper = NoteHelper.getInstance(getApplicationContext());
        noteHelper.open();

        note = getIntent().getParcelableExtra(EXTRA_NOTE);

        if (note != null) {
            isEdit = true;
        } else {
            note = new Note();
        }

        String actionBarTitle;

        if (isEdit) {
            actionBarTitle = "Edit Note";

            if (note != null) {
                binding.etTitle.setText(note.getTitle());
                binding.etContent.setText(note.getContent());
            }
            binding.ibDelete.setVisibility(View.VISIBLE);
        } else {
            actionBarTitle = "Add Note";
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(actionBarTitle);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        binding.ibSave.setOnClickListener(v -> {
            saveNote();
        });

        binding.ibDelete.setOnClickListener(v -> {
            new AlertDialog.Builder(this)
                    .setTitle("Delete Note")
                    .setMessage("Are you sure you want to delete this note?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            deleteNote();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
        });

        binding.ibBack.setOnClickListener(v -> {
            new AlertDialog.Builder(this)
                    .setTitle("Return to homepage")
                    .setMessage("Are you sure you want to go back? all of your proggres will be deleted")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
        });
    }

    private void saveNote() {
        String title = binding.etTitle.getText().toString().trim();
        String content = binding.etContent.getText().toString().trim();
        String createdDate = getCurrentDateTime();

        if (title.isEmpty()) {
            binding.etTitle.setError("Title cannot be empty");
            return;
        }

        if (content.isEmpty()) {
            binding.etContent.setError("Content cannot be empty");
            return;
        }

        note.setTitle(title);
        note.setContent(content);

        if (isEdit) {
            createdDate = "Updated at " + createdDate;
        } else {
            createdDate = "Created at " + createdDate;
        }

        note.setCreatedDate(createdDate);

        Intent intent = new Intent();
        intent.putExtra(EXTRA_NOTE, note);

        ContentValues values = new ContentValues();
        values.put(DatabaseContract.NoteColumns.TITLE, title);
        values.put(DatabaseContract.NoteColumns.CONTENT, content);
        values.put(DatabaseContract.NoteColumns.CREATED_DATE, createdDate);

        if (isEdit) {
            long result = noteHelper.update(String.valueOf(note.getId()), values);

            if (result > 0) {
                setResult(RESULT_UPDATE, intent);
                finish();
            } else {
                Toast.makeText(this, "Failed to update data", Toast.LENGTH_SHORT).show();
            }
        } else {
            long result = noteHelper.insert(values);

            if (result > 0) {
                note.setId((int) result);
                setResult(RESULT_ADD, intent);
                finish();
            } else {
                Toast.makeText(this, "Failed to add data", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void deleteNote() {
        if (note != null && note.getId() > 0) {
            long result = noteHelper.deleteById(String.valueOf(note.getId()));

            if (result > 0) {
                setResult(RESULT_DELETE);
                finish();
            } else {
                Toast.makeText(this, "Failed to delete data", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Failed to delete data", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Return to homepage")
                .setMessage("Are you sure you want to go back? All of your progress will be deleted")
                .setPositiveButton("Yes", (dialog, which) -> {
                    super.onBackPressed();
                })
                .setNegativeButton("No", null)
                .show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (noteHelper != null) {
            noteHelper.close();
        }
    }

    String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
        return sdf.format(new Date());
    }

}