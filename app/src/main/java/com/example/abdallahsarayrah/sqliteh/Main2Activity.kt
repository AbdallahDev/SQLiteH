package com.example.abdallahsarayrah.sqliteh

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var obj = DatabaseHelp(this)

        buttonFind.setOnClickListener {
            var db = obj.readableDatabase
            var cursor = db.rawQuery("select * from users where id = ?", arrayOf(editTextId.text.toString()))
            cursor.moveToFirst()
            if (cursor.count > 0) {
                editTextName.setText(cursor.getString(cursor.getColumnIndex("name")))
            } else Toast.makeText(this, "User not found", Toast.LENGTH_SHORT).show()

        }

        buttonAdd.setOnClickListener {
            var db = obj.writableDatabase
            db.execSQL("insert into users(name) values(?)", arrayOf(editTextName.text.toString()))
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
        }

        buttonEdit.setOnClickListener {
            var db = obj.writableDatabase
            db.execSQL("update users set name = ? where id = ?", arrayOf(editTextName.text.toString(), editTextId.text.toString()))
            Toast.makeText(this, "Name changed", Toast.LENGTH_SHORT).show()

        }

        buttonDelete.setOnClickListener {
            var db = obj.writableDatabase
            db.execSQL("delete from users where id = ?", arrayOf(editTextId.text.toString()))
            Toast.makeText(this, "User deleted", Toast.LENGTH_SHORT).show()
        }
    }
}
