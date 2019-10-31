package com.skiteldev.myapplication.connection;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.*;

public class SQLLiteConnection extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "mydatabase";
    private static String DB_PATH = "";
    private Context myContext;
    private SQLiteDatabase mDataBase;
    private boolean mNeedUpdate = true;

    public SQLLiteConnection(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        myContext = context;
        DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        System.out.println(DB_PATH);
        copyDataBase();

        this.getReadableDatabase();
    }

    public void createDataBase() {
        boolean dbExist = checkDataBase();
        if (!dbExist)
            this.getReadableDatabase();
        copyDataBase();

    }
    public void updateDataBase() throws IOException {
        if (mNeedUpdate) {
            File dbFile = new File(DB_PATH + DATABASE_NAME);
            if (dbFile.exists()) {
                System.out.println("dwqd");
                dbFile.delete();
            }
            copyDataBase();

            mNeedUpdate = false;
        }
    }

    private void copyDataBase() {
        if (!checkDataBase()) {
            this.getReadableDatabase();
            this.close();
            try {
                copyDBFile();
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }

    private void copyDBFile() throws IOException {
        InputStream myInput = myContext.getAssets().open(DATABASE_NAME);
        String outFileName = DB_PATH + DATABASE_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[10];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH + DATABASE_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException ignored) {

        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("create table users (id INTEGER PRIMARY KEY AUTOINCREMENT, username VARChar(255), password PASSWORD)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
            mNeedUpdate = true;
    }
    public boolean openDataBase() throws SQLException {
         mDataBase = SQLiteDatabase.openDatabase(DB_PATH + DATABASE_NAME, null,
                SQLiteDatabase.OPEN_READONLY);
        return mDataBase != null;
    }
    @Override
    public synchronized void close() {
        if (mDataBase != null)
            mDataBase.close();
        super.close();
    }
}
