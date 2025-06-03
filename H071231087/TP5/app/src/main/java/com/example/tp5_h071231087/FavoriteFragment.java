package com.example.tp5_h071231087;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FavoriteFragment extends Fragment {

    private RecyclerView recyclerView;
    private BookAdapter adapter;
    private ProgressBar progressBar;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final Handler handler = new Handler(Looper.getMainLooper());


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        recyclerView = view.findViewById(R.id.rv_favorite);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



        progressBar = view.findViewById(R.id.progress_bar);
        recyclerView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        executor.execute(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.post(() -> {
                List<Book> favoriteBooks = BookDataSource.getFavoriteBooks();
                adapter = new BookAdapter(
                        getContext(),
                        favoriteBooks,
                        R.layout.item_favorite_book);
                recyclerView.setAdapter(adapter);
                recyclerView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
            });
        });


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
//        adapter.notifyDataSetChanged();
        loadFavorites();
    }

    private void loadFavorites() {
        List<Book> favoriteBooks = BookDataSource.getFavoriteBooks();
        adapter = new BookAdapter(
                getContext(),
                favoriteBooks,
                R.layout.item_favorite_book);
        recyclerView.setAdapter(adapter);
    }

}