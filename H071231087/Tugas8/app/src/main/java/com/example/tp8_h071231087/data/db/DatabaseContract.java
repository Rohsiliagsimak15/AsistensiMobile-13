package com.example.tp8_h071231087.data.db;

import android.provider.BaseColumns;

public class DatabaseContract {
    public static String TABLE_NAME="Note";

    public static final class NoteColumns implements BaseColumns {
        public static String TITLE="title";
        public static String CONTENT="content";
        public static String CREATED_DATE="created_date";
    }
}