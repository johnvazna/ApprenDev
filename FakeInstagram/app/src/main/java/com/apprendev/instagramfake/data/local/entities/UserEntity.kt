package com.apprendev.instagramfake.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "last_name") val last_name: String
)