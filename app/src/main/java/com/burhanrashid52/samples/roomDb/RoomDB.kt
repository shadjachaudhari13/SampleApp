package com.burhanrashid52.samples.roomDb

import android.content.Context
import android.arch.persistence.room.Room


/**
 * Created by Burhanuddin Rashid on 1/5/2018.
 */

object RoomDB {
    fun getDefaultInstance(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "database-name")
                .allowMainThreadQueries()
                .build()
    }
}
