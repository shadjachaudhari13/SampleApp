package com.burhanrashid52.samples.motionLayout

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.burhanrashid52.samples.R

class MotionActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MotionActivity"
        fun launch(context: Context) {
            val intent = Intent(context, MotionActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion)
    }
}
