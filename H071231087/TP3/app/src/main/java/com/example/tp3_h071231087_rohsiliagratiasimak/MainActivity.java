package com.example.tp3_h071231087_rohsiliagratiasimak;
//package filenya

//Mengimpor kelas-kelas yang diperlukan untuk aktivitas Android,
// termasuk untuk tampilan, log, dan pengelolaan tata letak.
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    //mendeklarasikan setiap variabel untuk elemen UI
    ImageView ib_profile;
    ImageButton ib_addPost;

    @Override

    //Metode yang dipanggil saat aktivitas dibuat.
    // Memanggil super.onCreate untuk memastikan inisialisasi dari kelas induk.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Menambahkan listener untuk menyesuaikan
        // padding tampilan utama agar tidak tertutup oleh sistem bar.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //memuat semua data pengguna dari sumber data.
        try {
            UserDataSource.getAllUsers(this);
            //Mengatur RecyclerView untuk menampilkan cerita
            // (story) secara horizontal menggunakan LinearLayoutManager.
            RecyclerView rv_storyFeed = findViewById(R.id.rv_story);
            StoryFeedAdapter storyFeedAdapter = new StoryFeedAdapter(this, StoryDataSource.generateDummyStoriesFeed());
            rv_storyFeed.setAdapter(storyFeedAdapter);
            rv_storyFeed.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


            //Mengatur RecyclerView untuk menampilkan feed
            // postingan secara vertikal menggunakan LinearLayoutManager.
            List<Post> feedPosts = PostDataSource.generateDummyPostsFeed();
            PostFeedAdapter adapter = new PostFeedAdapter(this, feedPosts);
            RecyclerView rv_feed = findViewById(R.id.rv_feed);
            rv_feed.setLayoutManager(new LinearLayoutManager(this));
            rv_feed.setAdapter(adapter);

            //Menangkap dan mencatat kesalahan yang mungkin terjadi selama inisialisasi data dan adapter.
        } catch (Exception e) {
            Log.e("MainActivityError", "Error saat onCreate: ", e);
        }

        //Menghubungkan variabel dengan elemen UI yang sesuai di tata letak.
        ib_profile = findViewById(R.id.ib_profile);
        ib_addPost = findViewById(R.id.ib_addPost);


        //Menangani klik pada gambar profil dengan membuka
        // aktivitas ProfilePage dan mengirimkan data username.
        ib_profile.setOnClickListener(v -> {
            Intent intent = new Intent(this, ProfilePage.class);
            intent.putExtra("username", "roses_are_rosie");
            startActivity(intent);
        });


        //Menangani klik pada tombol tambah postingan dengan membuka aktivitas AddPost.
        ib_addPost.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddPost.class);
            startActivity(intent);
        });


    }
}