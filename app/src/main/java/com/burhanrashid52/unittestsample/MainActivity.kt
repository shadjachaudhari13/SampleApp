package com.burhanrashid52.unittestsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.burhanrashid52.unittestsample.db.RoomDB
import java.beans.PropertyChangeListener

class MainActivity : AppCompatActivity() {


    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userDao = RoomDB.getDefaultInstance(context = this).userDao()
    }
}
