package com.example.tp6_h071231087;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ApiService apiService;
    private UserAdapter userAdapter;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private TextView errorTextView;
    private Button retryButton;

    private final List<User> allUsers = new ArrayList<>();
    private int currentPage = 1;
    private boolean isLastPage = false;
    private boolean isLoading = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        errorTextView = findViewById(R.id.errorTextView);
        retryButton = findViewById(R.id.retryButton);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        userAdapter = new UserAdapter(allUsers, () -> {
            if (!isLastPage) {
                currentPage++;
                loadData(currentPage, false); // load more
            } else {
                Toast.makeText(this, "No more pages!", Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(userAdapter);

        loadData(currentPage, true); // initial load

        // Set listener untuk tombol refresh
        retryButton.setOnClickListener(v -> {
            errorTextView.setVisibility(View.GONE); // Sembunyikan pesan error
            progressBar.setVisibility(View.VISIBLE);
            loadData(currentPage, true); // Coba lagi untuk load data
        });
    }

    private void loadData(int page, boolean isInitialLoad) {
        if (isLoading) return;
        isLoading = true;

        // Sembunyikan error dan tombol retry saat mencoba lagi
        errorTextView.setVisibility(View.GONE);
        retryButton.setVisibility(View.GONE);

        if (isInitialLoad) {
            progressBar.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }

        apiService = RetrofitClient.getClient().create(ApiService.class);
        Call<UserResponse> call = apiService.getCharacters(page);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                isLoading = false;

                progressBar.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);

                if (response.isSuccessful() && response.body() != null) {
                    List<User> userList = response.body().getResults();
                    allUsers.addAll(userList);
                    userAdapter.notifyDataSetChanged();

                    isLastPage = (response.body().getInfo().getNext() == null);
                    userAdapter.setShowLoadMore(!isLastPage);
                } else {
                    showError();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                isLoading = false;
                progressBar.setVisibility(View.GONE);
                showError();
            }
        });
    }


    private void showError() {
        errorTextView.setVisibility(View.VISIBLE); // Menampilkan pesan error
        retryButton.setVisibility(View.VISIBLE);  // Menampilkan tombol refresh
    }
}