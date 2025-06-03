package com.example.tp3_h071231087_rohsiliagratiasimak;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

//mengimplementasikan Parcelable agar dapat dikirim antar komponen Android.
public class Story implements Parcelable {
    private User user;
    private String title;
    private String time;
    private int StoryImage;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public int getStoryImage() {
        return StoryImage;
    }

    public void setStoryImage(int storyImage) {
        StoryImage = storyImage;
    }


    //Konstruktor ini digunakan untuk membuat objek Story
    // dengan nilai-nilai tertentu untuk setiap atribut
    public Story(User user, String title, String time, int storyImage) {
        this.user = user;
        this.title = title;
        this.time = time;
        StoryImage = storyImage;
    }


    //Metode ini biasanya mengembalikan 0,
    // kecuali jika objek memiliki deskriptor file khusus.
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeParcelable(this.user, flags);
        dest.writeString(this.title);
        dest.writeString(this.time);
        dest.writeInt(this.StoryImage);
    }

    protected Story(Parcel in) {
        user = in.readParcelable(User.class.getClassLoader());
        title = in.readString();
        time = in.readString();
        StoryImage = in.readInt();
    }

    public static final Creator<Story> CREATOR = new Creator<Story>() {
        @Override
        public Story createFromParcel(Parcel in) {
            return new Story(in);
        }

        @Override
        public Story[] newArray(int size) {
            return new Story[size];
        }
    };
}
