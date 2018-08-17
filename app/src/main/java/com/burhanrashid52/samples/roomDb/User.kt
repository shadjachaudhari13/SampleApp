package com.burhanrashid52.samples.roomDb

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class User(
        @PrimaryKey
        var uid: Int = 0,
        var firstName: String = "",
        var lastName: String = ""
)