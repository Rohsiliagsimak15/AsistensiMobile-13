package com.example.tp2_h071231087_rohsiliagratiasimak;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class EditProfileActivity extends AppCompatActivity {

    private EditText et_name, et_username, et_bio, et_email, et_phone, et_jenisKelamin, et_tanggalLahir;
    private ImageView iv_ProfilePicture;
    private Button btn_save, btn_change_photo;
    private Uri profileUri;
    private ActivityResultLauncher<Intent> imagePickerLauncher;

    //menghubungkan masing-masing ID dari komponen layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        // Inisialisasi komponen UI
        et_name = findViewById(R.id.et_name);
        et_username = findViewById(R.id.et_username);
        et_bio = findViewById(R.id.et_bio);
        et_email = findViewById(R.id.et_email);
        et_phone = findViewById(R.id.et_phone);
        et_jenisKelamin = findViewById(R.id.et_jenisKelamin);
        et_tanggalLahir = findViewById(R.id.et_tanggalLahir);
        iv_ProfilePicture = findViewById(R.id.iv_ProfilePicture);
        btn_change_photo = findViewById(R.id.btn_change_photo);
        btn_save = findViewById(R.id.btn_save);

        //Saat field tanggal diklik, akan muncul dialog pemilih tanggal (date picker)
        et_tanggalLahir.setOnClickListener(v -> {
            showDatePickerDialog();
        });


        //Ini fungsinya buat prefill data user di form, jadi kalau sebelumnya sudah ada data user, akan langsung muncul di input field-nya.
        User user = getIntent().getParcelableExtra("USER_DATA");

        if (user != null ) {
            et_name.setText(user.getName());
            et_bio.setText(user.getBio());
            et_username.setText(user.getUsername());
            et_email.setText(user.getEmail());
            et_phone.setText(user.getNomorHP());
            et_tanggalLahir.setText(user.getTanggalLahir());
            et_jenisKelamin.setText(user.getJenisKelamin());

            if (user.getImageUri() != null && !user.getImageUri().isEmpty()) {
                profileUri = Uri.parse(user.getImageUri());
                iv_ProfilePicture.setImageURI(profileUri);
            }

        }

        //ini digunakan untuk mengambil gambar dari galeri
        imagePickerLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                            Uri imageUri = result.getData().getData();
                            if (imageUri != null) {
                                final int takeFlags = Intent.FLAG_GRANT_READ_URI_PERMISSION;
                                getContentResolver().takePersistableUriPermission(imageUri, takeFlags);
                                profileUri = imageUri;
                                iv_ProfilePicture.setImageURI(profileUri);

                            }
                        }
                    }
                });

        //Ketika tombol "Change Photo" ditekan, akan memanggil galeri untuk memilih gambar
        findViewById(R.id.btn_change_photo).setOnClickListener(v -> {
            openGallery();
        });

        //Ini tombol kembali ke halaman utama (MainActivity) saat ditekan
        ImageButton backButton = findViewById(R.id.ivBack);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditProfileActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });


        //logika utama penyimpanan data untuk memvalidasi input satu per satu misalnya nama tidak kosong
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "";
                String username = "";
                String bio = "";
                String email = "";
                String phone = "";
                String tanggalLahir = "";
                String jenisKelamin = "";
                String profilURIString = "";

                if (et_name.getText() != null && !et_name.getText().toString().trim().isEmpty()) {
                    if (et_name.getText().length() <= 50) {
                        name = et_name.getText().toString();
                    } else {
                        Toast.makeText(EditProfileActivity.this, "Maksimal jumlah huruf adalah 50", Toast.LENGTH_SHORT).show();
                        return;
                    }
                } else {
                    Toast.makeText(EditProfileActivity.this, "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (et_username.getText() != null && !et_username.getText().toString().trim().isEmpty()) {
                    if (et_username.getText().length() <= 20) {
                        username = et_username.getText().toString();
                    } else {
                        Toast.makeText(EditProfileActivity.this, "Maksimal jumlah huruf adalah 20", Toast.LENGTH_SHORT).show();
                        return;
                    }
                } else {
                    Toast.makeText(EditProfileActivity.this, "Username tidak boleh kosong", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (et_email.getText() != null && !et_email.getText().toString().trim().isEmpty()) {
                        email = et_email.getText().toString();
                } else {
                    Toast.makeText(EditProfileActivity.this, "Email tidak boleh kosong", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (et_phone.getText() != null && !et_phone.getText().toString().trim().isEmpty()) {
                    if (et_phone.getText().length() <= 15) {
                        phone = et_phone.getText().toString();
                    } else {
                        Toast.makeText(EditProfileActivity.this, "Maksimal jumlah huruf adalah 12", Toast.LENGTH_SHORT).show();
                        return;
                    }
                } else {
                    Toast.makeText(EditProfileActivity.this, "Nomor Telepon tidak boleh kosong", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (et_bio.getText() != null) {
                    if (et_bio.getText().length() <= 160) {
                        bio = et_bio.getText().toString();
                    } else {
                        Toast.makeText(EditProfileActivity.this, "Maks. Character is 160", Toast.LENGTH_SHORT).show();
                        return;
                    }
                } else {
                    Toast.makeText(EditProfileActivity.this, "Bio tidak boleh kosong", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (et_jenisKelamin.getText() != null && !et_jenisKelamin.getText().toString().trim().isEmpty()) {
                    if (et_jenisKelamin.getText().toString().equalsIgnoreCase("perempuan") || et_jenisKelamin.getText().toString().equalsIgnoreCase("laki-laki")) {
                        jenisKelamin = et_jenisKelamin.getText().toString();
                    } else {
                        Toast.makeText(EditProfileActivity.this, "Input jenis kelamin hanya perempuan atau laki-laki", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                if (et_tanggalLahir.getText() != null) {
                    tanggalLahir = et_tanggalLahir.getText().toString();
                }

                //Jika user memilih gambar baru, URI-nya diambil dan diubah jadi string untuk disimpan di User.
                if (profileUri != null) {
                    profilURIString = profileUri.toString();
                }

                //Setelah semua validasi selesai, buat object User, kirim balik ke Activity sebelumnya (dengan setResult) lalu finish() untuk menutup halaman edit.
                User user = new User(profilURIString, name, username, bio, email, phone, jenisKelamin, tanggalLahir);
//                Intent intent = new Intent(EditProfileActivity.this, MainActivity.class);
//                setResult(Activity.RESULT_OK, intent);
//                finish();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("USER_DATA", user);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();

            }
        });
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        imagePickerLauncher.launch(Intent.createChooser(intent, "Pilih Gambar"));
    }

    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    calendar.set(selectedYear, selectedMonth, selectedDay);

                    SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
                    String formattedDate = sdf.format(calendar.getTime());

                    et_tanggalLahir.setText(formattedDate);
                },
                year, month, day
        );

        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis() - 1000);

        datePickerDialog.show();
    }
}