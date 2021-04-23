package com.apprendev.instagramfake.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.apprendev.instagramfake.data.local.dao.ExploreDao
import com.apprendev.instagramfake.data.local.dao.PostDao
import com.apprendev.instagramfake.data.local.dao.UserDao
import com.apprendev.instagramfake.data.local.entities.ExploreEntity
import com.apprendev.instagramfake.data.local.entities.PostEntity
import com.apprendev.instagramfake.data.local.entities.UserEntity

@Database(entities = [UserEntity::class, PostEntity::class, ExploreEntity::class], version = 4, exportSchema = false)
abstract class LocalDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun postDao(): PostDao
    abstract fun exploreDao(): ExploreDao

    companion object {
        @Volatile
        private var instance: LocalDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, LocalDatabase::class.java, "mydatabase.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }

}