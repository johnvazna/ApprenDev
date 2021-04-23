package com.apprendev.instagramfake.data.local.dao

import androidx.room.*
import com.apprendev.instagramfake.data.local.entities.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createUser(user: UserEntity)

    @Update
    fun update(user: UserEntity)

    @Delete
    fun delete(user: UserEntity)

    @Query("select * from users where id = :id")
    fun getUserById(id: Int): UserEntity

}