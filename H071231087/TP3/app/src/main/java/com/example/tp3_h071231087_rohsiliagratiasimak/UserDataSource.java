package com.example.tp3_h071231087_rohsiliagratiasimak;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class UserDataSource {
    private static List<User> userList = new ArrayList<>();

    public static List<User> getAllUsers(Context context) {
        if (userList.isEmpty()) {
            generateDummyUsers(context);
        }
        return userList;
    }

    public static void generateDummyUsers(Context context) {
        if (!userList.isEmpty()) return;

        userList.add(new User("roses_are_rosie", "ROSE", "83,7JT", "0", "Artist", "Artis papan atas ini bos", "https://www.youtube.com/@roses_are_rosie", R.drawable.post_profilerose));
        userList.add(new User("blackpinkofficial", "BLΛƆKPIИK", "57,5JT", "5", "Girl Group", "blackpink in your area", "https://www.youtube.com/@blackpink", R.drawable.profile_blackpink));
        userList.add(new User("lalalalisa_m", "LISA", "105JT", "0", "Artis/Girl Group", "ALTER EGO", "https://www.youtube.com/@wearelloud", R.drawable.profile_lisa));
        userList.add(new User("jennierubyjane", "J", "87,1JT", "0", "Artis/Girl Group", "LIKE JENNIE", "https://www.youtube.com/@jennierubyjane", R.drawable.profile_jennie));
        userList.add(new User("sooyaa__", "JISSO\uD83E\uDE90", "79,8JT", "0", "Artis/Girl Group", "earthquake ", "https://www.youtube.com/@sooyaaa__", R.drawable.profile_jisoo));
        userList.add(new User("mahaliniraharja", "", "7,1JT", "2.180", "Artis/Penyanyi", "(+62) 81514566398 (@biondy_akbar )", "bfan.link/mencintaimu-5", R.drawable.profile_mahalini));
        userList.add(new User("songkang_b", "", "22JT", "0", "Aktor", "송강", "https://www.instagram.com/songkang_b", R.drawable.profile_songkang));
        userList.add(new User("real__pcy", "EXO_CY", "23,7JT", "8", "Musisi", "EXO-L\uD83E\uDD0D\n", "https://www.youtube.com/@CHANYEOLyoutube", R.drawable.profile_chanyeol));
        userList.add(new User("zkdlin", "KAI", "14,2JT", "0", "Musisi", "WAIT ON ME", "youtu.be/JLqXeMabsEQ?si=yn3r3H8pnlnYvdlA", R.drawable.profile_kai));
        userList.add(new User("oohsehun", "SEHUN", "22,9JT", "0", "Musisi", "오세훈", "https://www.youtube.com/@weareoneEXO", R.drawable.profile_sehun));
        userList.add(new User("yoona__lim", "", "17,6JT", "8", "Artist", "yoona's so wonderful day", "https://www.youtube.com/@limyoona__official", R.drawable.profile_yoona));


    }

    public static User getUserByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}