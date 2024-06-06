package com.aam.applydigitaltechnicalinterview.data.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aam.applydigitaltechnicalinterview.data.model.entity.HitsEntity

@Dao
interface HackerNewsDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllHits(hits: List<HitsEntity>)

    @Query("SELECT * FROM Hits ORDER BY createdAt DESC")
    suspend fun getAllHits(): List<HitsEntity>
}