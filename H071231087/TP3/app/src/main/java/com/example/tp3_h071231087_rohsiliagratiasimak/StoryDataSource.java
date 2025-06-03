package com.example.tp3_h071231087_rohsiliagratiasimak;

import java.util.ArrayList;
import java.util.List;

public class StoryDataSource {


    public static List<Story>  generateDummyStoriesFeed() {
        List<Story> storyList = new ArrayList<>();

        User rose = UserDataSource.getUserByUsername("roses_are_rosie");
        User bp = UserDataSource.getUserByUsername("blackpinkofficial");
        User lisa = UserDataSource.getUserByUsername("lalalalisa_m");
        User jennie = UserDataSource.getUserByUsername("jennierubyjane");
        User jisoo = UserDataSource.getUserByUsername("sooyaa__");
        User mahalini = UserDataSource.getUserByUsername("mahaliniraharja");
        User songkang = UserDataSource.getUserByUsername("songkang_b");
        User chanyeol = UserDataSource.getUserByUsername("real__pcy");
        User kai = UserDataSource.getUserByUsername("zkdlin");
        User sehun = UserDataSource.getUserByUsername("oohsehun");
        User yoona = UserDataSource.getUserByUsername("yoona__lim");



        storyList.add(new Story(rose, null, "2h", R.drawable.post_profilerose));
        storyList.add(new Story(bp, null, "3h", R.drawable.profile_blackpink));
        storyList.add(new Story(lisa, null, "15h", R.drawable.profile_lisa));
        storyList.add(new Story(jennie,null, "7h", R.drawable.profile_jennie));
        storyList.add(new Story(jisoo, null, "1h", R.drawable.profile_jisoo));
        storyList.add(new Story(mahalini, null, "6h", R.drawable.profile_mahalini));
        storyList.add(new Story(songkang, null, "11h", R.drawable.profile_songkang));
        storyList.add(new Story(chanyeol, null, "18h", R.drawable.profile_chanyeol));
        storyList.add(new Story(kai, null, "2h", R.drawable.profile_kai));
        storyList.add(new Story(sehun, null, "23h", R.drawable.profile_sehun));
        storyList.add(new Story(yoona, null, "14h", R.drawable.profile_yoona));




        return storyList;
    }

    public static List<Story>  generateDummyStoryHighlights(String username) {
        List<Story> allHighlights = new ArrayList<>();

        User rose = UserDataSource.getUserByUsername("roses_are_rosie");
        User bp = UserDataSource.getUserByUsername("blackpinkofficial");
        User lisa = UserDataSource.getUserByUsername("lalalalisa_m");
        User jennie = UserDataSource.getUserByUsername("jennierubyjane");
        User jisoo = UserDataSource.getUserByUsername("sooyaa__");
        User mahalini = UserDataSource.getUserByUsername("mahaliniraharja");
        User songkang = UserDataSource.getUserByUsername("songkang_b");
        User chanyeol = UserDataSource.getUserByUsername("real__pcy");
        User kai = UserDataSource.getUserByUsername("zkdlin");
        User sehun = UserDataSource.getUserByUsername("oohsehun");
        User yoona = UserDataSource.getUserByUsername("yoona__lim");

        allHighlights.add(new Story(rose,"chela 25", "18 April", R.drawable.post_rose1));
        allHighlights.add(new Story(rose,"\uD83D\uDC99", "18 November 2024", R.drawable.post_rose2));
        allHighlights.add(new Story(rose,"\uD83D\uDDA4", "5 September 2024", R.drawable.post_rose3));
        allHighlights.add(new Story(rose,"Jerman", "25 Juni 2024", R.drawable.post_rose4));
        allHighlights.add(new Story(rose,"☀", "1 Juni 2024", R.drawable.post_rose5));
        allHighlights.add(new Story(rose,"ysl", "9 Maret 2024", R.drawable.post_rose6));
        allHighlights.add(new Story(rose,"ysl too", "2 November 2023", R.drawable.post_rose7));


        allHighlights.add(new Story(bp, "1", "28 April 2023", R.drawable.post_blackpink1));
        allHighlights.add(new Story(bp, "2", "28 April 2023", R.drawable.post_blackpink2));
        allHighlights.add(new Story(bp, "3", "28 April 2023", R.drawable.post_blackpink3));
        allHighlights.add(new Story(bp, "4", "28 April 2023", R.drawable.post_blackpink4));
        allHighlights.add(new Story(bp, "5", "28 April 2023", R.drawable.post_blackpink5));
        allHighlights.add(new Story(bp, "6", "28 April 2023", R.drawable.post_blackpink6));
        allHighlights.add(new Story(bp, "choachella", "28 April 2023", R.drawable.post_blackpink7));


        allHighlights.add(new Story(lisa, "\uD83C\uDF3B", "22 Agustus 2024", R.drawable.post_lisa1));
        allHighlights.add(new Story(lisa, "\uD83C\uDF7D\uFE0F", "7 Agustus 2024", R.drawable.post_lisa2));
        allHighlights.add(new Story(lisa, "circuit", "3 Agustus 2024", R.drawable.post_lisa3));
        allHighlights.add(new Story(lisa, "✨", "27 Mei 2024", R.drawable.post_lisa4));
        allHighlights.add(new Story(lisa, "Las Vegas", "25 November 2023", R.drawable.post_lisa5));
        allHighlights.add(new Story(lisa, "holiday", "24 Juli 2023", R.drawable.post_lisa6));
        allHighlights.add(new Story(lisa, "smile", "5 Januari 2025", R.drawable.post_lisa7));


        allHighlights.add(new Story(jennie, "\uD83D\uDDA4", "29 Januari 2025", R.drawable.post_jennie6));
        allHighlights.add(new Story(jennie, "\uD83C\uDDEB\uD83C\uDDF7 2", "29 Januari 2025", R.drawable.post_jennie1));
        allHighlights.add(new Story(jennie, "night", "28 Januari 2025", R.drawable.post_jennie2));
        allHighlights.add(new Story(jennie, "birthday", "15 March 2025", R.drawable.post_jennie3));
        allHighlights.add(new Story(jennie, "walk", "18 Januari 2025", R.drawable.post_jennie5));
        allHighlights.add(new Story(jennie, "adidas", "8 Juli 2024", R.drawable.post_jennie4));
        allHighlights.add(new Story(jennie, "\uD83C\uDDEB\uD83C\uDDF7 1", "16 September 2022", R.drawable.post_jennie7));

        allHighlights.add(new Story(jisoo, "dior", "22 November 2024", R.drawable.post_jisoo1));
        allHighlights.add(new Story(jisoo, "black", "15 September 2024", R.drawable.post_jisoo2));
        allHighlights.add(new Story(jisoo, "\uD83C\uDDEB\uD83C\uDDF7", "26 Juni 2024", R.drawable.post_jisoo3));
        allHighlights.add(new Story(jisoo, "✨", "28 Mei 2024", R.drawable.post_jisoo4));
        allHighlights.add(new Story(jisoo, "Cartier", "25 Februari 2024", R.drawable.post_jisoo5));
        allHighlights.add(new Story(jisoo, "\uD83C\uDDEC\uD83C\uDDE7", "25 November 2023", R.drawable.post_jisoo6));
        allHighlights.add(new Story(jisoo, "Shumon", "17 November 2023", R.drawable.post_jisoo7));

        allHighlights.add(new Story(mahalini, "lebaran", "17 November 2023", R.drawable.post_mahalini1));
        allHighlights.add(new Story(mahalini, "italia", "17 November 2023", R.drawable.post_mahalini2));
        allHighlights.add(new Story(mahalini, "\uD83E\uDD0D\n", "17 November 2023", R.drawable.post_mahalini3));
        allHighlights.add(new Story(mahalini, "\uD83C\uDF3C", "17 November 2023", R.drawable.post_mahalini4));
        allHighlights.add(new Story(mahalini, "\uD83C\uDF03", "17 November 2023", R.drawable.post_mahalini5));
        allHighlights.add(new Story(mahalini, "new year", "17 November 2023", R.drawable.post_mahalini6));
        allHighlights.add(new Story(mahalini, "paris", "17 November 2023", R.drawable.post_mahalini7));

        allHighlights.add(new Story(songkang, "orange", "14 Maret 2024", R.drawable.post_songkang1));
        allHighlights.add(new Story(songkang, "black", "8 Desember 2023", R.drawable.post_songkang2));
        allHighlights.add(new Story(songkang, "blue", "20 Maret 2023", R.drawable.post_songkang3));
        allHighlights.add(new Story(songkang, "hei!", "4 Maret 2023", R.drawable.post_songkang4));
        allHighlights.add(new Story(songkang, "sea", "4 November 2021", R.drawable.post_songkang5));
        allHighlights.add(new Story(songkang, "CARIN", "31 Agustus 2021", R.drawable.post_songkang6));
        allHighlights.add(new Story(songkang, "\uD83D\uDC99\n", "19 April 2021", R.drawable.post_songkang7));

        allHighlights.add(new Story(chanyeol, " ", "18 April", R.drawable.post_chanyeol1));
        allHighlights.add(new Story(chanyeol, "black out", "5 September 2024", R.drawable.post_chanyeol2));
        allHighlights.add(new Story(chanyeol, " ", "17 September 2023", R.drawable.post_chanyeol3));
        allHighlights.add(new Story(chanyeol, "puppies", "26 Juni 2019", R.drawable.post_chanyeol4));
        allHighlights.add(new Story(chanyeol, "TEMPO", "26 Oktober 2018", R.drawable.post_chanyeol5));
        allHighlights.add(new Story(chanyeol, "beach", "30 Maret 2018", R.drawable.post_chanyeol6));
        allHighlights.add(new Story(chanyeol, " ", "19 Desember 2016", R.drawable.post_chanyeol7));


        allHighlights.add(new Story(kai, "\uD83C\uDFA7", "24 Maret", R.drawable.post_kai1));
        allHighlights.add(new Story(kai, " ", "18 Februari 2023", R.drawable.post_kai2));
        allHighlights.add(new Story(kai, "Yokohama", "30 Januari 2023", R.drawable.post_kai3));
        allHighlights.add(new Story(kai, "\uD83E\uDDF8", "27 November 2022", R.drawable.post_kai4));
        allHighlights.add(new Story(kai, "Paris", "8 September 2022", R.drawable.post_kai5));
        allHighlights.add(new Story(kai, " ", "11 Juni 2022", R.drawable.post_kai6));
        allHighlights.add(new Story(kai, "Vanila", "26 November 2021", R.drawable.post_kai7));


        allHighlights.add(new Story(sehun, " ", "7 September 2023", R.drawable.post_sehun1));
        allHighlights.add(new Story(sehun, " ", "5 Desember 2022", R.drawable.post_sehun2));
        allHighlights.add(new Story(sehun, "Piramid", "3 Desember 2022", R.drawable.post_sehun3));
        allHighlights.add(new Story(sehun, "Dior", "20 Juni 2022", R.drawable.post_sehun4));
        allHighlights.add(new Story(sehun, "✌\uD83C\uDFFB\uFE0F", "28 Oktober 2021", R.drawable.post_sehun5));
        allHighlights.add(new Story(sehun, " ", "31 Maret 2021", R.drawable.post_sehun6));
        allHighlights.add(new Story(sehun, "black & white", "31 Maret 2021", R.drawable.post_sehun7));


        allHighlights.add(new Story(yoona, "2025", "14 Januari", R.drawable.post_yoona1));
        allHighlights.add(new Story(yoona, "Valentino", "1 Oktober 2024", R.drawable.post_yoona2));
        allHighlights.add(new Story(yoona, " \uD83D\uDC40\n", "29 Juli 2024", R.drawable.post_yoona3));
        allHighlights.add(new Story(yoona, "summer", "11 Juni 2024", R.drawable.post_yoona4));
        allHighlights.add(new Story(yoona, "Mei", "1 Mei 2024", R.drawable.post_yoona5));
        allHighlights.add(new Story(yoona, "cheers", "8 Oktober 2023", R.drawable.post_yoona6));
        allHighlights.add(new Story(yoona, "⛳", "31 Agustus 2023", R.drawable.post_yoona7));






        List<Story> filtered = new ArrayList<>();
        for (Story story : allHighlights) {
            if (story.getUser().getUsername().equals(username)) {
                filtered.add(story);
            }
        }
        return filtered;
    }
}