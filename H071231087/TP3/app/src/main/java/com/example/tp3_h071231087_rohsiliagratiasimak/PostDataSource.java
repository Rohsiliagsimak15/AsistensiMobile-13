package com.example.tp3_h071231087_rohsiliagratiasimak;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class PostDataSource {
    public static List<Post> newPosts = new ArrayList<>();

    public static void addNewPost(Post post) {
        newPosts.add(0, post); // tambah di awal biar muncul di paling atas feed
    }
    public static List<Post> generateDummyPostsFeed() {
        List<Post> postsList = new ArrayList<>();
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

        postsList.addAll(newPosts);

        postsList.add(new Post(rose, "chela 25", "18 April 2025", "4JT", "15,7rb", "60,4rb", R.drawable.post_rose1));
        postsList.add(new Post(bp, "#BLACKPINK ##블랙핑크 #COACHELLA #WEEK2 #BEHIND #PHOTO #YG", "23 April 2023", "943rb", "468", "75", R.drawable.post_blackpink1));
        postsList.add(new Post(lisa, "yellow", "3 Agustus 2024", "5,9JT", "31,2rb", "1234", R.drawable.post_lisa1));
        postsList.add(new Post(jennie, "\uD83C\uDDEB\uD83C\uDDF7", "29 Januari 2025", "4,2JT", "14,2rb", "43,1rb", R.drawable.post_jennie1));
        postsList.add(new Post(jisoo, "So honored to have been invited to the royal palace for a lovely banquet & to have received honorary MBEs! \uD83C\uDF80\n" + "Thank you for the unforgettable experience!\uD83C\uDDEC\uD83C\uDDE7", "25 November 2025", "4,1JT", "26rb", "42,7rb", R.drawable.post_jisoo1));
        postsList.add(new Post(mahalini, "mudiq\uD83C\uDDEC\uD83D\uDE9E\uD83D\uDE8D\uD83D\uDE9D\uD83D\uDE87\uD83D\uDE84\uD83D\uDE85\uD83D\uDCA8\uD83D\uDCA8\uD83D\uDCA8", "1 April", "1,7JT", "6.817", "9.669", R.drawable.post_mahalini1));
        postsList.add(new Post(songkang, "☺", "14 Maret 2024", "4,5JT", "43,5rb", "14,7rb", R.drawable.post_songkang1));
        postsList.add(new Post(chanyeol, " ", "18 April", "708rb", "24,3rb", "11,4rb", R.drawable.post_chanyeol1));
        postsList.add(new Post(kai, " ", "24 Maret", "1,1JT", "16,1rb", "16rb", R.drawable.post_kai1));
        postsList.add(new Post(sehun, " ", "7 September 2023", "1,2JT", "32,5rb", "9rb", R.drawable.post_sehun1));
        postsList.add(new Post(yoona, "2025\uD83D\uDE47\uD83C\uDFFB\u200D♀\uFE0F", "14 Januari", "823rb", "5.260", "11,1rb", R.drawable.post_yoona1));



        return postsList;
    }

    public static List<Post> generateDummyPostProfilePage(String username) {
        List<Post> postsList = new ArrayList<>();
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


        postsList.add(new Post(rose, "chela 25 ◡̈", "18 April", "4JT", "15,7rb", "60,4rb", R.drawable.post_rose1));
        postsList.add(new Post(rose, "\uD83D\uDC99 @i_d \uD83D\uDC99", "18 November 2024", "3,8JT", "13,5rb", "60,4rb", R.drawable.post_rose2));
        postsList.add(new Post(rose, "@saintlaurentbabylone #PinaultCollection in Seoul. \uD83D\uDDA4", "5 September 2024", "3,6JT", "21,8rb", "60,4rb", R.drawable.post_rose3));
        postsList.add(new Post(rose, "\uD83D\uDC08\u200D⬛", "25 Juni 2024", "4,2JT", "30,8rb", "60,4rb", R.drawable.post_rose4));
        postsList.add(new Post(rose, "\uD83C\uDF1E may.", "1 Juni 2024", "5,5JT", "44,4rb", "60,4rb", R.drawable.post_rose5));
        postsList.add(new Post(rose, "Saint Laurent pre-oscar party in @ysl @anthonyvaccarello ❤", "9 Maret 2024", "3,4JT", "20,9rb", "60,4rb", R.drawable.post_rose6));

        postsList.add(new Post(bp, "#BLACKPINK ##블랙핑크 #COACHELLA #WEEK2 #BEHIND #PHOTO #YG", "28 April 2023", "943rb", "468", "75", R.drawable.post_blackpink1));
        postsList.add(new Post(bp, "#BLACKPINK ##블랙핑크 #COACHELLA #WEEK2 #BEHIND #PHOTO #YG", "28 April 2023", "3,4JT", "8.363", "16,6rb", R.drawable.post_blackpink2));
        postsList.add(new Post(bp, "#BLACKPINK ##블랙핑크 #COACHELLA #WEEK2 #BEHIND #PHOTO #YG", "28 April 2023", "872rb", "1.314", "144", R.drawable.post_blackpink3));
        postsList.add(new Post(bp, "#BLACKPINK ##블랙핑크 #COACHELLA #WEEK2 #BEHIND #PHOTO #YG", "25 April 2023", "910rb", "517", "97", R.drawable.post_blackpink6));
        postsList.add(new Post(bp, "#BLACKPINK ##블랙핑크 #COACHELLA #WEEK2 #BEHIND #PHOTO #YG", "25 April 2023", "1,9JT", "3.577", "953", R.drawable.post_blackpink5));
        postsList.add(new Post(bp, "#BLACKPINK ##블랙핑크 #COACHELLA #WEEK2 #BEHIND #PHOTO #YG", "25 April 2023", "1,9JT", "3.577", "953", R.drawable.post_blackpink4));

        postsList.add(new Post(lisa, "\uD83C\uDF4B\uD83C\uDF3C\uD83D\uDC25", "22 Agustus 2024", "5,9JT", "31,2rb", "1234", R.drawable.post_lisa1));
        postsList.add(new Post(lisa, "lunch", "7 Agustus 2024", "7,5JT", "39,5rb", "117", R.drawable.post_lisa2));
        postsList.add(new Post(lisa, "\uD83C\uDFCE\uFE0F\uD83C\uDFC1", "3 Agustus 2024", "6,8JT", "40,5rb", "972", R.drawable.post_lisa3));
        postsList.add(new Post(lisa, "So deeply honored to be a part of this great moment. I would have never imagined standing here receiving an Honorary MBE so thank you and will forever cherish this moment✨", "27 Mei 2024", "6,7JT", "52,2rb", "861", R.drawable.post_lisa4));
        postsList.add(new Post(lisa, "Las Vegas! First time performing here in this vibrant city and your energy was insane\uD83D\uDD25Vegas Blinks know how to party\uD83E\uDD18\uD83C\uDFFB", "25 November 2023", "5,8JT", "51,8rb", "543", R.drawable.post_lisa5));
        postsList.add(new Post(lisa, "\uD83C\uDF4A", "24 Juli 2023", "10JT", "81,8rb", "746", R.drawable.post_lisa6));

        postsList.add(new Post(jennie, "\uD83C\uDDEB\uD83C\uDDF7", "29 Januari", "4,2JT", "14,2rb", "43,1rb", R.drawable.post_jennie6));
        postsList.add(new Post(jennie, "\uD83C\uDDEB\uD83C\uDDF7", "29 Januari", "4,2JT", "14,2rb", "43,1rb", R.drawable.post_jennie1));
        postsList.add(new Post(jennie, "Windy Paris. See you tomorrow", "28 Januari", "4,4JT", "17rb", "70,8rb", R.drawable.post_jennie2));
        postsList.add(new Post(jennie, "Thank you for all the sweet bday wishes \uD83D\uDC99\n" + "생일 축하해줘서 곰마워 \uD83D\uDC3B", "18 Januari", "6,2JT", "46rb", "101rb", R.drawable.post_jennie3));
        postsList.add(new Post(jennie, "\uD83E\uDE75", "8 Juli 2024", "4,2JT", "14,2rb", "43,1rb", R.drawable.post_jennie5));
        postsList.add(new Post(jennie, "adidas", "16 September 2022", "6,5JT", "35,3rb", "904", R.drawable.post_jennie4));

        postsList.add(new Post(jisoo, "@ellekorea @dior 과 함께 미리 크리스마스\uD83C\uDF84", "22 November 2024", "5,2JT", "34,8rb", "101rb", R.drawable.post_jisoo1));
        postsList.add(new Post(jisoo, "\uD83D\uDC08\u200D⬛", "18 September 2024", "3,9JT", "27,3rb", "51,8rb", R.drawable.post_jisoo2));
        postsList.add(new Post(jisoo, "La Tour Eiffel de cet été ☁", "26 Juni 2024", "6,4JT", "37rb", "76,8rb", R.drawable.post_jisoo3));
        postsList.add(new Post(jisoo, "⭐별⭐", "28 Mei 2024", "4,5JT", "36,7rb", "84,6rb", R.drawable.post_jisoo4));
        postsList.add(new Post(jisoo, "아름다웠던 아를에서\n" + "@Cartier\n" + "#CartierTrinity\n" + "#Trinity100Celebration", "25 Februari 2024", "4,6JT", "29,4rb", "65,6rb", R.drawable.post_jisoo5));
        postsList.add(new Post(jisoo, "So honored to have been invited to the royal palace for a lovely banquet & to have received honorary MBEs! \uD83C\uDF80\n" + "Thank you for the unforgettable experience!\uD83C\uDDEC\uD83C\uDDE7", "25 November 2023", "4,1JT", "26rb", "42,7rb", R.drawable.post_jisoo6));

        postsList.add(new Post(mahalini, "mudiq\uD83C\uDDEC\uD83D\uDE9E\uD83D\uDE8D\uD83D\uDE9D\uD83D\uDE87\uD83D\uDE84\uD83D\uDE85\uD83D\uDCA8\uD83D\uDCA8\uD83D\uDCA8", "1 April", "1,7JT", "6.817", "9.669", R.drawable.post_mahalini1));
        postsList.add(new Post(mahalini, "rumah\uD83E\uDD0D", "13 April 2024", "717rb", "3.792", "3.838", R.drawable.post_mahalini3));
        postsList.add(new Post(mahalini, "Taken by @rizkyfbian yang harus diambekin dulu ampe nemu foto bagus\uD83E\uDD77\uD83C\uDFFB", "2 Januari 2024", "430rb", "1.191", "862", R.drawable.post_mahalini2));
        postsList.add(new Post(mahalini, "harus ada taken by @rizkyfbian nya\uD83D\uDC79\n", "21 November 2023", "1,1JT", "6.738", "6.332", R.drawable.post_mahalini4));
        postsList.add(new Post(mahalini, "my dear, we're slow dancing in a burning room", "1 Desember 2021", "113rb", "394", "14", R.drawable.post_mahalini5));
        postsList.add(new Post(mahalini, "happy new year\uD83E\uDD70\n", "2 Januari 2021", "94,3rb", "444", "215", R.drawable.post_mahalini6));

        postsList.add(new Post(songkang, "☺", "14 Maret 2024", "4,5JT", "43,5rb", "14,7rb", R.drawable.post_songkang1));
        postsList.add(new Post(songkang, "\uD83D\uDE08\uFE0F\uD83D\uDE31☺", "8 Desember 2023", "4,8JT", "27,2rb", "8rb", R.drawable.post_songkang2));
        postsList.add(new Post(songkang, "\uD83E\uDD79\uFE0F\uD83D\uDE2D하하", "20 Maret 2023", "3,6JT", "14,8rb", "6,4rb", R.drawable.post_songkang3));
        postsList.add(new Post(songkang, "\uD83D\uDE10", "4 Maret 2023", "3,2JT", "18,2rb", "9,1rb", R.drawable.post_songkang4));
        postsList.add(new Post(songkang, "눈이 안떠...져으...억\uD83E\uDD7A", "4 November 2021", "4,8JT", "54rb", "4,7rb", R.drawable.post_songkang5));
        postsList.add(new Post(songkang, "#광고#카린#CARIN#알렉스☺\uFE0F", "31 Agustus 2021", "3,6JT", "32,8rb", "7,7rb", R.drawable.post_songkang6));

        postsList.add(new Post(chanyeol, " ", "18 April", "708rb", "24,3rb", "11,4rb", R.drawable.post_chanyeol1));
        postsList.add(new Post(chanyeol, "black out", "5 September 2024", "824rb", "30,7rb", "7,4rb", R.drawable.post_chanyeol2));
        postsList.add(new Post(chanyeol, " ", "17 September 2023", "1,6JT", "39,4rb", "16,2rb", R.drawable.post_chanyeol3));
        postsList.add(new Post(chanyeol, "열심히 살았고 잘하고있어 찬열아\uD83D\uDE4F", "26 Juni 2019", "2,2JT", "33,7rb", "29rb", R.drawable.post_chanyeol4));
        postsList.add(new Post(chanyeol, "TEMPO", "26 Oktober 2018", "2,4JT", "111rb", "64,8rb", R.drawable.post_chanyeol5));
        postsList.add(new Post(chanyeol, "\uD83C\uDFC4\uD83C\uDFFB\u200D♀\uFE0F", "30 Maret 2018", "2,5JT", "114rb", "54rb", R.drawable.post_chanyeol6));

        postsList.add(new Post(kai, " ", "24 Maret", "1,1JT", "16,1rb", "16rb", R.drawable.post_kai1));
        postsList.add(new Post(kai, "\uD83E\uDE9E", "18 Februari 2023", "1,8JT", "22rb", "13,6rb", R.drawable.post_kai2));
        postsList.add(new Post(kai, "요코하마 안녕\uD83D\uDC4B", "30 Januari 2023", "1,3JT", "11,8rb", "6rb", R.drawable.post_kai3));
        postsList.add(new Post(kai, "#gucci", "27 November 2022", "1,6JT", "17,1rb", "6rb", R.drawable.post_kai4));
        postsList.add(new Post(kai, "파리안녕\uD83D\uDC37", "8 September 2022", "1,3JT", "13,3rb", "5,2rb", R.drawable.post_kai5));
        postsList.add(new Post(kai, " ", "11 Juni 2022", "1,5JT", "17,6rb", "8,6rb", R.drawable.post_kai6));

        postsList.add(new Post(sehun, " ", "7 September 2023", "1,2JT", "32,5rb", "9rb", R.drawable.post_sehun1));
        postsList.add(new Post(sehun, " ", "5 Desember 2022", "3,4JT", "51,5rb", "7.858", R.drawable.post_sehun2));
        postsList.add(new Post(sehun, " ", "3 Desember 2022", "1,6JT", "21,9rb", "11,2rb", R.drawable.post_sehun3));
        postsList.add(new Post(sehun, "DIOR BY BIRKENSTOCK", "20 Juni 2022", "2,1JT", "32,7rb", "884", R.drawable.post_sehun4));
        postsList.add(new Post(sehun, "#oh!ViVi #SPAO", "28 Oktober 2021", "2,6JT", "58,9rb", "542", R.drawable.post_sehun5));
        postsList.add(new Post(sehun, " ", "31 Maret 2021", "2,8JT", "76,8rb", "1.770", R.drawable.post_sehun6));

        postsList.add(new Post(yoona, "2025\uD83D\uDE47\uD83C\uDFFB\u200D♀\uFE0F", "14 Januari", "823rb", "5.260", "11,1rb", R.drawable.post_yoona1));
        postsList.add(new Post(yoona, "파리에서 ❤\uFE0F", "1 Oktober 2024", "1,1JT", "4.005", "3.681", R.drawable.post_yoona2));
        postsList.add(new Post(yoona, "외출\uD83D\uDC40\n" + "#연극 #맥베스", "29 Juli 2024", "1,5JT", "4.999", "6.761", R.drawable.post_yoona3));
        postsList.add(new Post(yoona, "☀\uFE0F", "11 Juni 2024", "1,1JT", "4.472", "5.140", R.drawable.post_yoona4));
        postsList.add(new Post(yoona, "5월", "1 Mei 2024", "897rb", "4,717", "3.099", R.drawable.post_yoona5));
        postsList.add(new Post(yoona, "이 공간 넘흐 맘에 들었\uD83D\uDE0E", "8 Oktober 2023", "1JT", "5.312", "2.213", R.drawable.post_yoona6));



        List<Post> filtered = new ArrayList<>();
        for (Post post : newPosts) {
            if (post.getUser().getUsername().equals(username)) {
                filtered.add(post);
            }
        }

        for (Post post : postsList) {
            if (post.getUser().getUsername().equals(username)) {
                filtered.add(post);
            }
        }
        return filtered;
    }
}

