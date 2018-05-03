package com.example.abdallahsarayrah.sqliteh

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        button2.setOnClickListener {
            var obj = DatabaseHelp(this)
            var db = obj.readableDatabase
            var cursor = db.rawQuery("select * from users where id = ?", arrayOf(editText2.text.toString()))

            when {
                cursor.count > 0 -> {
                    cursor.moveToFirst()
                    editText2.setText(cursor.getString(cursor.getColumnIndex("id")))
                    editText22.setText(cursor.getString(cursor.getColumnIndex("name")))
                }
                cursor.count == 0 -> Toast.makeText(this, "User not found", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
