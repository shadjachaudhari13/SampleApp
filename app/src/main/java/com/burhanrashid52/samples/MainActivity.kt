package com.burhanrashid52.samples

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.burhanrashid52.samples.motionLayout.MotionActivity
import com.burhanrashid52.samples.roomDb.RoomDB

class MainActivity : AppCompatActivity() {


    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MotionActivity.launch(this)
        //Test comment
    }
}
