package com.example.tp3_h071231087_rohsiliagratiasimak;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddPost extends AppCompatActivity {
    private ImageView iv_chosenPhoto;
    private ImageButton ib_back;
    private EditText et_caption;
    private Button btn_share;
    private Uri imagePost;

    private boolean isTrue = false;

    private ActivityResultLauncher<Intent> imagePickerLauncher; // Launcher untuk ambil gambar dari galeri

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Membuat UI lebih modern, konten extend ke edge layar
        setContentView(R.layout.activity_add_post);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {  // Mengatur padding supaya tidak ketutupan system bars (status bar/navigation bar)
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi view dari layout
        ib_back = findViewById(R.id.ib_back);
        iv_chosenPhoto = findViewById(R.id.iv_chosenPhoto);
        et_caption = findViewById(R.id.et_caption);
        btn_share = findViewById(R.id.btn_share);

        // Aksi tombol back: kembali ke halaman sebelumnya

        ib_back.setOnClickListener(v -> {

            finish();
        });

        // Mengecek apakah result dari galeri OK
        ActivityResultLauncher<Intent> imagePickerLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                        Uri imageUri = result.getData().getData();
                        if (imageUri != null) {
                            final int takeFlags = Intent.FLAG_GRANT_READ_URI_PERMISSION;
                            getContentResolver().takePersistableUriPermission(imageUri, takeFlags);

                            // langsung assign ke imagePost dan tampilkan ke ImageView
                            imagePost = imageUri;
                            iv_chosenPhoto.setImageURI(imagePost);
                        }
                    }
                });

        iv_chosenPhoto.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            imagePickerLauncher.launch(Intent.createChooser(intent, "Pilih Gambar"));
        });

        btn_share.setOnClickListener(v -> {
            String caption = et_caption.getText().toString();
            String time = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(new Date());
            User user = UserDataSource.getUserByUsername("roses_are_rosie");

            if (user != null && imagePost != null) {
                Post newPost = new Post(user, caption, time, imagePost);
                PostDataSource.addNewPost(newPost); // Simpan post ke "database" (dummy)

                Intent intent = new Intent(AddPost.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //biar refresh
                startActivity(intent);
            } else {
                Toast.makeText(this, "Make sure to fill every field", Toast.LENGTH_SHORT).show();
            }
        });
    }
}