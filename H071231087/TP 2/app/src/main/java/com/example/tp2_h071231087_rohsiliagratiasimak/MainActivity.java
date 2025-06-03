package com.example.tp2_h071231087_rohsiliagratiasimak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvName, tvPhone; // Teks untuk menampilkan nama & nomor HP
    private ImageView ivProfile, ivEdit; // Gambar profil & tombol edit
    private static final int REQUEST_EDIT_PROFILE = 1; // Kode request untuk edit profile
    private User user; // Objek user yang menampung data pengguna

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi komponen UI
        tvName = findViewById(R.id.tvName);
        tvPhone = findViewById(R.id.tvPhone);
        ivProfile = findViewById(R.id.ivProfile);
        ivEdit = findViewById(R.id.ivEdit);

        // Set data default untuk user
        user = new User(
                "",
                "Rohsilia Gratia Simak",
                "tiaaa",
                "",
                "rohsiliagratia@gmail.com",
                "6456789876544",
                "Perempuan",
                ""
        );


        // Ketika tombol edit ditekan, buka EditProfileActivity dengan membawa data user
        ivEdit.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, EditProfileActivity.class);
            intent.putExtra("USER_DATA", user);
            startActivityForResult(intent, REQUEST_EDIT_PROFILE);
        });
    }

    // Callback ketika kembali dari EditProfileActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        // Jika kembali dari halaman edit dan data berhasil diperbarui
        if (requestCode == REQUEST_EDIT_PROFILE && resultCode == RESULT_OK && data != null) {
            User updatedUser = data.getParcelableExtra("USER_DATA");

            // Pastikan data tidak null
             if (updatedUser != null) {
                 // Jika tidak memilih foto baru, gunakan foto lama
                 if (updatedUser.getImageUri() == null || updatedUser.getImageUri().isEmpty()) {
                     updatedUser.setImageUri(user.getImageUri());
                 }

                 // Update objek user
                 user = updatedUser;
             }

             updateUI();
        }
    }

    // Fungsi untuk menampilkan data user ke tampilan utama
    private void updateUI() {
        if (user != null) {
            tvName.setText(user.getName());
            tvPhone.setText(user.getNomorHP());

            // Tampilkan foto profil jika URI tersedia
            if (user.getImageUri() != null && !user.getImageUri().isEmpty()) {
                Uri profileUri = Uri.parse(user.getImageUri());
                ivProfile.setImageURI(null);
                ivProfile.setImageURI(profileUri);
            }
        }
    }
}