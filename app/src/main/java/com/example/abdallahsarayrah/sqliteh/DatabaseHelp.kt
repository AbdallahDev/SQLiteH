package com.example.abdallahsarayrah.sqliteh

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by abdallah.sarayrah on 10/15/2017.
 */
class DatabaseHelp(context: Context) : SQLiteOpenHelper(context, "Events", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table users(id integer primary key autoincrement, name text)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}