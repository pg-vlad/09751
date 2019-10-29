package com.skiteldev.myapplication.connection;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLLiteConnection extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db/mydatabase.db";
    private static final String TABLE_USERS = "users";

    private static final String TABLE_ID = "id";
    private static final String TABLE_USERNAME = "username";
    private static final String TABLE_PASS = "password";


    public SQLLiteConnection(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
