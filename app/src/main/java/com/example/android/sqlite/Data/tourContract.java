package com.example.android.sqlite.Data;

import android.provider.BaseColumns;

/**
 * Created by Owner on 4/2/2017.
 */

public class tourContract {
    public static abstract class tourEntry implements BaseColumns{
        public static final String TABLE_NAME = "trip";
        public static final String DATABASE_NAME = "tour";
        public static final String NAME = "name";
        public static final String DATE = "date";

    }
}
