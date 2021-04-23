package com.apprendev.instagramfake.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "explorer")
data class ExploreEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "image") val image: String
)
