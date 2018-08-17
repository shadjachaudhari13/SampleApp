package com.burhanrashid52.samples.dbTest

import android.arch.persistence.room.Room
import android.content.Context
import android.support.test.runner.AndroidJUnit4
import com.burhanrashid52.samples.roomDb.AppDatabase
import com.burhanrashid52.samples.roomDb.User
import com.burhanrashid52.samples.roomDb.UserDao
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class RoomInstrumentedTest {

    private lateinit var mDB: AppDatabase
    private lateinit var userDao: UserDao

    @Before
    fun setupRoom() {
        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this)
        val context = Mockito.mock(Context::class.java)
        mDB = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        userDao = mDB.userDao()
    }

    @Test
    fun insertSingleUserTest() {
        userDao.insertAll(User(1, "Burhanuddin", "Rashid"))
        val user = userDao.findByName("Burhanuddin", "Rashid")
        assertEquals("Burhanuddin", user.firstName)
        assertEquals("Rashid", user.lastName)
    }

    @Test
    fun insertBulkUsersTest() {
        val userList = DummyUtil.getDummyUser(0..200)
        userDao.insertAll(userList)
        val getAllUsers = userDao.getAll
        for (i in getAllUsers.indices) {
            assertEquals(userList[i], getAllUsers[i])
        }
    }

    @Test
    fun deleteUserSuccess() {
        val userList = DummyUtil.getDummyUser(0..20)
        userDao.insertAll(userList)
        userDao.delete(userList[5])
        val userById = userDao.findUserById(userList[5].uid)
        assertEquals(null, userById)
    }

    @Test
    fun deleteUserFailed() {
        val userList = DummyUtil.getDummyUser(0..20)
        userDao.insertAll(userList)
        userDao.delete(userList[5])
        val userById = userDao.findUserById(userList[6].uid)
        assertNotEquals(null, userById)
    }

    @Test
    fun updateUserFailed() {
        val dummyUser = DummyUtil.getDummyUser(0..1)[0]
        dummyUser.firstName = "Updated"
        userDao.update(dummyUser)
        val findUserById = userDao.findUserById(dummyUser.uid)
        assertEquals(null, findUserById)
    }

    @Test
    fun updateUserSuccess() {
        val dummyUser = DummyUtil.getDummyUser(0..1)[0]
        userDao.insertAll(dummyUser)
        assertEquals("0 First", dummyUser.firstName)
        dummyUser.firstName = "Updated"
        userDao.update(dummyUser)
        val findUserById = userDao.findUserById(dummyUser.uid)
        assertEquals(dummyUser.firstName, findUserById.firstName)
    }

    @After
    fun cleanUp() {
        mDB.close()
    }
}
