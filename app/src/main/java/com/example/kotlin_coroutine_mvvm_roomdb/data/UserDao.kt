package com.example.roomapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.kotlin_coroutine_mvvm_roomdb.model.User


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>


}