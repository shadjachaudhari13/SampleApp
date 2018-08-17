package com.burhanrashid52.samples.dbTest

import com.burhanrashid52.samples.roomDb.User

/**
 * Created by Burhanuddin Rashid on 1/8/2018.
 */
object DummyUtil {
    fun getDummyUser(userRange: IntRange): List<User> {
        return with(userRange) {
            this.map { User(it, "$it First", "$it last") }
        }
    }
}