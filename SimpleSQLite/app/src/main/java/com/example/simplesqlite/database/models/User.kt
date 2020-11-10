package com.example.simplesqlite.database.models

data class User(
    val id: Int,
    val userId: String,
    val name: String,
    val email: String,
    val password: String
)