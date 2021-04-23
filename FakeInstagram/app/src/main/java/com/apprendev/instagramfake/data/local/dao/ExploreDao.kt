package com.apprendev.instagramfake.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.apprendev.instagramfake.data.local.entities.ExploreEntity

@Dao
interface ExploreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(exploreEntity: ExploreEntity)

    @Query("select * from explorer")
    fun getExploreData(): List<ExploreEntity>

}