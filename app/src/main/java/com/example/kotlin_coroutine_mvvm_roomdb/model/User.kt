package com.example.kotlin_coroutine_mvvm_roomdb.model


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String
)