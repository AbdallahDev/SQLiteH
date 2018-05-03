package com.example.abdallahsarayrah.sqliteh

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by abdallah.sarayrah on 10/9/2017.
 */

class DatabaeHelperOneOne(context: Context) : SQLiteOpenHelper(context, "mydatabaserr", null, 1) {

    init {
        val db = this.writableDatabase
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table usertable(id integer primary key autoincrement, name text)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }
}
