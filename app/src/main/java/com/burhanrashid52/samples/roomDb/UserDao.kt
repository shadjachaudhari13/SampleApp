package com.burhanrashid52.samples.roomDb

import android.arch.persistence.room.*

@Dao
interface UserDao {

    @get:Query("SELECT * FROM user")
    val getAll: List<User>

    /*@Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>*/

    @Query("SELECT * FROM user WHERE firstName LIKE :first AND lastName LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): User

    @Query("SELECT * FROM user WHERE uid = :id ")
    fun findUserById(id: Int): User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg users: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<User>)

    @Delete
    fun delete(user: User)

    @Update
    fun update(user: User)
}