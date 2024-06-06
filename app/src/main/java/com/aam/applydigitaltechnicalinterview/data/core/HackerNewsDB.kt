package com.aam.applydigitaltechnicalinterview.data.core

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aam.applydigitaltechnicalinterview.data.model.dao.HackerNewsDAO
import com.aam.applydigitaltechnicalinterview.data.model.entity.HitsEntity

@Database(entities = [HitsEntity::class], version = 7, exportSchema = false)
abstract class HackerNewsDB : RoomDatabase() {
    abstract fun hackerNewsDAO() : HackerNewsDAO
}