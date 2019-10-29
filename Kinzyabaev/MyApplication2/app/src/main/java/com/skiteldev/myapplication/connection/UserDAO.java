package com.skiteldev.myapplication.connection;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDAO {

    SQLiteDatabase sqlLiteConnection;

    public UserDAO(SQLiteDatabase sqLiteDatabase) {
        sqlLiteConnection = sqLiteDatabase;
    }

    public boolean findUser(String user, String pass) {
        String SQL = "SELECT * FROM users where username = ? and password = ?";
        //            setPreparedStatement(getConnection().prepareStatement(SQL));
//            getPreparedStatement().setString(1, user);
//            getPreparedStatement().setString(2, pass);
//            setResultSet(getPreparedStatement().executeQuery());
//            return getSet().next();
        Cursor cursor = sqlLiteConnection.rawQuery(SQL, new String[] {user, pass});
        return cursor.moveToFirst();
    }
}
