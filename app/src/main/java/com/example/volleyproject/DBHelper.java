package com.example.volleyproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private final static int _DBVersion = 1; //<-- 版本
    private final static String _DBName = "PlayerData";	//<-- db name
    private final static String _TableName = "PlayerData"; //<-- table name
    public DBHelper(Context context) {
        super(context, _DBName, null, _DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         String SQL = "CREATE TABLE IF NOT EXISTS " + _TableName + "( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT"+
                ");";
        db.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
