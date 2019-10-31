package com.skiteldev.myapplication.connection;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDAO {

    private SQLLiteConnection sqlLiteConnection;

    public UserDAO(SQLLiteConnection sqLiteDatabase) {
        sqlLiteConnection = sqLiteDatabase;
    }

    public boolean findUser(String user, String pass) {
        String SQL = "SELECT * FROM users where username = ? and password = ?";
        //            setPreparedStatement(getConnection().prepareStatement(SQL));
//            getPreparedStatement().setString(1, user);
//            getPreparedStatement().setString(2, pass);
//            setResultSet(getPreparedStatement().executeQuery());
//            return getSet().next();
        SQLiteDatabase mDb;
        mDb = sqlLiteConnection.getReadableDatabase();

        Cursor cursor = mDb.rawQuery(SQL, new String[] {user, pass});
        return cursor.moveToFirst();

    }
}
