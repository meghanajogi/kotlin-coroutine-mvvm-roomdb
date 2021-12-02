package com.example.kotlin_coroutine_mvvm_roomdb.repository

import androidx.lifecycle.LiveData
import com.example.kotlin_coroutine_mvvm_roomdb.model.User
import com.example.roomapp.data.UserDao


class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }


    suspend fun deleteUser(user: User){
        userDao.deleteUser(user)
    }



}