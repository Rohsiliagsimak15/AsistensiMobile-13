package com.example.tp2_h071231087_rohsiliagratiasimak;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable{

    private String imageUri, name, username, bio, email, phone, jenisKelamin, tanggalLahir;

    public User (String imageUri, String name, String username, String bio, String email, String phone, String jenisKelamin, String tanggalLahir) {
        this.imageUri = imageUri;
        this.name = name;
        this.username = username;
        this.bio = bio;
        this.email = email;
        this.phone = phone;
        this.jenisKelamin = jenisKelamin;
        this.tanggalLahir = tanggalLahir;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomorHP() {
        return phone;
    }

    public void setNomorHP(String phone) {
        this.phone = phone;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }


    protected User(Parcel in) {
        imageUri = in.readString();
        name = in.readString();
        username = in.readString();
        bio = in.readString();
        email = in.readString();
        phone = in.readString();
        jenisKelamin = in.readString();
        tanggalLahir = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imageUri);
        dest.writeString(name);
        dest.writeString(username);
        dest.writeString(bio);
        dest.writeString(email);
        dest.writeString(phone);
        dest.writeString(jenisKelamin);
        dest.writeString(tanggalLahir);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };


}

