package com.example.tp6_h071231087;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private ImageView ivImage;
    private TextView tvName, tvStatus, tvSpecies, tvGender, tvError;
    private ProgressBar progressBar;
    private Button btnRefresh;
    private CardView card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        ivImage = findViewById(R.id.ivImage);
        tvName = findViewById(R.id.tvName);
        tvStatus = findViewById(R.id.tvStatus);
        tvSpecies = findViewById(R.id.tvSpecies);
        tvGender = findViewById(R.id.tvGender);
        progressBar = findViewById(R.id.progressBar);
        card = findViewById(R.id.cardView);
        tvError = findViewById(R.id.tvError);
        btnRefresh = findViewById(R.id.btnRefresh);

        // Tampilkan progress bar saat mulai
        showLoadingState();

        // Ambil ID user dari Intent
        int userId = getIntent().getIntExtra("user_id", -1);

        if (userId != -1) {
            // Delay untuk memastikan progressBar sempat terlihat
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                loadUserData(userId);
            }, 1000); // 500ms delay
        }

        // Tombol refresh
        btnRefresh.setOnClickListener(v -> {
            showLoadingState();
            loadUserData(userId);
        });
    }

    private void loadUserData(int userId) {
        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
        Call<User> call = apiService.getUserDetail(userId);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                progressBar.setVisibility(View.GONE);

                if (response.isSuccessful() && response.body() != null) {
                    User user = response.body();

                    // Set data ke tampilan
                    tvName.setText(user.getName());
                    tvStatus.setText(user.getStatus());
                    tvSpecies.setText(user.getSpecies());
                    tvGender.setText(user.getGender());

                    Picasso.get()
                            .load(user.getImage())
                            .placeholder(R.drawable.ic_launcher_background)
                            .error(R.drawable.ic_launcher_background)
                            .into(ivImage);

                    card.setVisibility(View.VISIBLE);
                    ivImage.setVisibility(View.VISIBLE);
                    tvName.setVisibility(View.VISIBLE);
                    tvStatus.setVisibility(View.VISIBLE);
                    tvSpecies.setVisibility(View.VISIBLE);
                    tvGender.setVisibility(View.VISIBLE);
                    btnRefresh.setVisibility(View.GONE);
                } else {
                    showError();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                showError();
            }
        });
    }

    private void showLoadingState() {
        progressBar.setVisibility(View.VISIBLE);
        card.setVisibility(View.GONE);
        ivImage.setVisibility(View.GONE);
        tvName.setVisibility(View.GONE);
        tvStatus.setVisibility(View.GONE);
        tvSpecies.setVisibility(View.GONE);
        tvGender.setVisibility(View.GONE);
        tvError.setVisibility(View.GONE);
        btnRefresh.setVisibility(View.GONE);
    }

    private void showError() {
        tvError.setVisibility(View.VISIBLE);
        btnRefresh.setVisibility(View.VISIBLE);
    }
}
