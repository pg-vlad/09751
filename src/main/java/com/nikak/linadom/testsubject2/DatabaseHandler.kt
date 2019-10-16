package com.nikak.linadom.testsubject2

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHandler(context: Context) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSIOM) {
    var db: SQLiteDatabase? = null

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE = "CREATE TABLE $TABLE_NAME " +
                "($ID Integer PRIMARY KEY, $LOGIN TEXT UNIQUE, $PASSWORD TEXT)"

        db?.execSQL(CREATE_TABLE)
        val insertValues = ContentValues()
        insertValues.put(LOGIN, "login")
        insertValues.put(PASSWORD, "password")
        val success = db?.insert(TABLE_NAME, null, insertValues)
//        db?.close()
        Log.v("InsertedID", "$success")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addUser(user: User): Boolean {
        //Create and/or open a database that will be used for reading and writing.
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(LOGIN, user.login)
        values.put(PASSWORD, user.password)
        val success = db.insert(TABLE_NAME, null, values)
        db.close()
        Log.v("InsertedID", "$success")
        return (Integer.parseInt("$success") != -1)
    }
    //get all users
    fun getAllUsers(): String {
        var allUser: String = "";
        val db = readableDatabase
        val selectALLQuery = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(selectALLQuery, null)
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    var id = cursor.getString(cursor.getColumnIndex(ID))
                    var firstName = cursor.getString(cursor.getColumnIndex(LOGIN))
                    var lastName = cursor.getString(cursor.getColumnIndex(PASSWORD))

                    allUser = "$allUser\n$id $firstName $lastName"
                } while (cursor.moveToNext())
            }
        }
        cursor.close()
        db.close()
        return allUser
    }

//    fun checkIfUserPresents(user: User):Boolean{
//        val cursor = db?.query(
//            TABLE_NAME,
//            arrayOf(LOGIN, PASSWORD),
//            "$LOGIN = ? AND $PASSWORD = ?",
//            arrayOf(user.login,user.password), null, null, null
//        )
//        cursor?.close()
//        return cursor?.count != 0
//    }

     fun checkIfUserPresent(user: User):Boolean {
        val login = user.login
        val password = user.password


        val database = readableDatabase
        val projection = arrayOf<String>(
            ID,
            LOGIN,
            PASSWORD
        )
        val selection = LOGIN + " like ? and " +
                PASSWORD + " like ?"
        val selectionArgs = arrayOf(login, password)
        val cursor = database.query(
            TABLE_NAME, // Запрашиваемая таблица
            projection, // Возвращаемый столбец
            selection, // Столбец для условия WHERE
            selectionArgs, // не фильтровать по группам строк
            null                                      // не сортировать
            , null, null
        )// Значение для условия WHERE
        // не группировать строки
        return cursor.count!=0
    }


    companion object {
        private val DB_NAME = "UsersDatabase"
        private val DB_VERSIOM = 1
        private val TABLE_NAME = "users"
        private val ID = "id"
        private val LOGIN = "Login"
        private val PASSWORD = "Password"
    }
}