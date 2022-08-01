package com.example.sql_database

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AddNameBtn.setOnClickListener {
            val db=DataBase(this,null)
            val name=Enter_Name.text.toString()
            val age=Enter_Age.text.toString()

            db.AddName(name, age)
            Toast.makeText(this,name+"added to db",Toast.LENGTH_LONG).show()
            Enter_Name.text.clear()
            Enter_Age.text.clear()
        }

        PrintNameBtn.setOnClickListener {
            val db=DataBase(this,null)

            val cursor=db.getName()
            cursor!!.moveToFirst()
            Name.append(cursor.getString(cursor.getColumnIndex(DataBase.NAME_COL))+ "\n")
            Age.append(cursor.getString(cursor.getColumnIndex(DataBase.AGE_COL))+ "\n")
            while (cursor.moveToNext()){
                Name.append(cursor.getString(cursor.getColumnIndex(DataBase.NAME_COL))+ "\n")
                Age.append(cursor.getString(cursor.getColumnIndex(DataBase.AGE_COL))+ "\n")

            }
            cursor.close()

        }
    }
}