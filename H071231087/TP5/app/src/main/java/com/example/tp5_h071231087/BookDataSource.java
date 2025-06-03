package com.example.tp5_h071231087;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class BookDataSource {
    private static List<Book> bookList = new ArrayList<>();
    private static List<Book> favoriteBooks = new ArrayList<>();

    public static void generateDummyBooks(Context context) {
        if (!bookList.isEmpty()) return;

        bookList.add(new Book("Perahu Kertas", "Dewi Lestari", "2009",
                "Perahu Kertas adalah kisah tentang Kugy dan Keenan, dua remaja dengan impian dan latar belakang berbeda. Mereka menjalin persahabatan yang kemudian berkembang menjadi cinta, namun harus menghadapi berbagai rintangan dan pilihan hidup. Novel ini menyajikan perjalanan emosional tentang cinta, impian, dan pencarian jati diri.",
                false,
                "android.resource://" + context.getPackageName() + "/" + R.drawable.perahu_kertas
        ));

        bookList.add(new Book("Laskar Pelangi", "Andrea Hirata", "2005",
                "Laskar Pelangi menceritakan kisah 10 anak dari keluarga miskin di Belitung yang berjuang untuk mendapatkan pendidikan. Dengan semangat dan tekad, mereka menghadapi berbagai tantangan untuk meraih mimpi mereka. Novel ini menginspirasi pembaca tentang pentingnya pendidikan dan semangat pantang menyerah.",
                false,
                "android.resource://" + context.getPackageName() + "/" + R.drawable.laskar_pelangi
        ));

        bookList.add(new Book("To Kill a Mockingbird", "Harper Lee", "1960",
                "Novel ini mengisahkan kehidupan Scout Finch dan saudaranya, Jem, di kota kecil Maycomb, Alabama, selama masa Depresi Besar. Ayah mereka, Atticus Finch, seorang pengacara yang membela seorang pria kulit hitam yang dituduh memperkosa wanita kulit putih. Melalui mata anak-anak, cerita ini mengeksplorasi isu rasial, ketidakadilan, dan moralitas.",
                false,
                "android.resource://" + context.getPackageName() + "/" + R.drawable.to_kill_a_mockingbird
        ));

        bookList.add(new Book("The Catcher in The Rye", "J.D. Salinger", "1951",
                "Holden Caulfield, seorang remaja yang dikeluarkan dari sekolah asrama, mengembara di New York City sambil merenungkan kehidupan dan kemunafikan orang dewasa. Novel ini menggambarkan alienasi dan pencarian identitas di masa remaja.",
                false,
                "android.resource://" + context.getPackageName() + "/" + R.drawable.the_catcher_in_the_rye
        ));

        bookList.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "1925",
                "Jay Gatsby, seorang pria kaya misterius, mengadakan pesta mewah untuk menarik perhatian Daisy Buchanan, cinta lamanya. Melalui narasi Nick Carraway, kita menyaksikan kehidupan glamor dan kehampaan era Jazz Age, serta tragedi yang menimpa Gatsby.",
                false,
                "android.resource://" + context.getPackageName() + "/" + R.drawable.the_great_gatsby
        ));

        bookList.add(new Book("Cantik itu Luka", "Eka Kurniawan", "2002",
                "Novel ini mengisahkan Dewi Ayu, seorang pelacur yang bangkit dari kubur setelah 21 tahun meninggal. Cerita ini memadukan unsur realisme magis dengan sejarah Indonesia, menggambarkan kehidupan masyarakat di Halimunda dengan berbagai konflik sosial dan politik.",
                false,
                "android.resource://" + context.getPackageName() + "/" + R.drawable.cantik_itu_luka
        ));

        bookList.add(new Book("Dilan: Dia adalah Dilanku Tahun 1990", "Pidi Baiq", "2014",
                "Dilan adalah kisah cinta remaja antara Dilan, seorang pemuda unik dan romantis, dengan Milea, gadis pindahan dari Jakarta. Berlatar belakang Bandung tahun 1990, novel ini membawa pembaca pada nostalgia masa SMA dengan segala kenangan manis dan pahitnya.",
                false,
                "android.resource://" + context.getPackageName() + "/" + R.drawable.dilan_dia_adalah_dilanku_tahun_1990
        ));

        bookList.add(new Book("Septimus Heap Fyre", "Angie Sage", "2013",
                "Dalam buku ketujuh dari seri Septimus Heap, Septimus menghadapi ancaman dari Darke Domaine. Dengan bantuan teman-temannya, ia harus menemukan cara untuk menghancurkan kekuatan jahat dan memulihkan keseimbangan sihir.",
                false,
                "android.resource://" + context.getPackageName() + "/" + R.drawable.septimus_heap_fyre
        ));

        bookList.add(new Book("The Kite Runner", "Khaled Hosseini", "2013",
                "The Kite Runner adalah kisah persahabatan antara Amir dan Hassan di Afghanistan yang dilanda konflik. Novel ini mengeksplorasi tema pengkhianatan, penebusan, dan hubungan ayah-anak, dengan latar belakang sejarah yang kuat.",
                false,
                "android.resource://" + context.getPackageName() + "/" + R.drawable.the_kite_runner
        ));

        bookList.add(new Book("The Notebook", "Nicholas Sparks", "1996",
                "The Notebook adalah kisah cinta abadi antara Noah dan Allie, yang terhalang oleh perbedaan sosial dan perang. Bertahun-tahun kemudian, mereka bertemu kembali, membuktikan bahwa cinta sejati tak pernah pudar.",
                false,
                "android.resource://" + context.getPackageName() + "/" + R.drawable.the_notebook
        ));

        bookList.add(new Book("Dan Hujan Pun Berhenti", "Farida Susanti", "2013",
                "Kisah tentang seorang wanita yang menghadapi trauma masa lalu dan mencoba menemukan kedamaian dalam hidupnya. Dengan latar belakang hujan yang terus-menerus, novel ini mengeksplorasi tema kehilangan, harapan, dan penyembuhan.",
                false,
                "android.resource://" + context.getPackageName() + "/" + R.drawable.dan_hujan_pun_berhenti
        ));

        bookList.add(new Book("Bumi Manusia", "Pramoedya Ananta Toer", "1980",
                "Bumi Manusia adalah novel pertama dari tetralogi Buru karya Pramoedya Ananta Toer. Novel ini mengisahkan kehidupan Minke, seorang pribumi terpelajar di masa kolonial Hindia Belanda, yang jatuh cinta pada Annelies, putri dari Nyai Ontosoroh. Melalui kisah cinta mereka, novel ini menggambarkan ketidakadilan sosial dan perjuangan identitas di tengah penjajahan.",
                false,
                "android.resource://" + context.getPackageName() + "/" + R.drawable.bumi_manusia
        ));

        bookList.add(new Book("Sapiens: A Brief History of Humankind", "Yuval Noah Harari", "2011",
                "Sapiens menyajikan perjalanan sejarah manusia dari zaman purba hingga era modern. Harari menggabungkan ilmu sejarah, biologi, dan antropologi untuk menjelaskan bagaimana Homo sapiens menjadi spesies dominan di bumi.",
                false,
                "android.resource://" + context.getPackageName() + "/" + R.drawable.sapiens
        ));

        bookList.add(new Book("Pride and Prejudice", "Jane Austen", "1913",
                "Elizabeth Bennet, seorang wanita cerdas dan mandiri, menghadapi tekanan sosial untuk menikah. Ketika bertemu dengan Mr. Darcy, seorang pria kaya namun sombong, mereka saling menilai dan menghadapi prasangka yang menghalangi cinta mereka. Sebuah kisah tentang cinta, kelas sosial, dan kesalahpahaman.",
                false,
                "android.resource://" + context.getPackageName() + "/" + R.drawable.pride_and_prejudice
        ));

        bookList.add(new Book("Me Before You", "Jojo Moyes", "2011",
                "Novel ini menceritakan Louisa Clark, seorang wanita muda yang menjadi pengasuh Will Traynor, pria kaya yang lumpuh setelah kecelakaan. Hubungan mereka berkembang, menghadirkan pertanyaan tentang cinta, kehidupan, dan pilihan.",
                false,
                "android.resource://" + context.getPackageName() + "/" + R.drawable.me_before_you
        ));

        bookList.add(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "1997",
                "Buku pertama dari seri Harry Potter ini memperkenalkan dunia sihir melalui mata Harry Potter, seorang anak yatim piatu yang menemukan bahwa ia adalah seorang penyihir. Di Hogwarts, ia menjalin persahabatan dan menghadapi tantangan yang mengungkap masa lalunya.",
                false,
                "android.resource://" + context.getPackageName() + "/" + R.drawable.harry_poter
        ));
    }


    public static void addBook(Book book) {
        bookList.add(0, book);
    }

    public static void clearBooks() {
        bookList.clear();
    }

    public static Object getBooks() {
        return bookList;
    }

    public static void addFavorite(Book book) {
        if (!favoriteBooks.contains(book)) {
            favoriteBooks.add(0, book);
            book.setLike(true);
        }
    }

    public static void removeFavorite(Book book) {
        favoriteBooks.remove(book);
        book.setLike(false);
    }


    public static List<Book> getFavoriteBooks() {
        return favoriteBooks;
    }

    public static boolean isFavorite(Book book) {
        return favoriteBooks.contains(book);
    }
}
