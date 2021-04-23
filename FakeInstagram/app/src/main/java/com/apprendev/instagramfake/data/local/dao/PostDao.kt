package com.apprendev.instagramfake.data.local.dao

import androidx.room.*
import com.apprendev.instagramfake.data.local.entities.PostEntity

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(post: PostEntity)

    @Update
    fun update(post: PostEntity)

    @Delete
    fun delete(post: PostEntity)

    @Query(value = "select * from post")
    fun getPosts(): List<PostEntity>

}