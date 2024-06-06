package com.aam.applydigitaltechnicalinterview.injection

import android.content.Context
import androidx.room.Room
import com.aam.applydigitaltechnicalinterview.data.core.HackerNewsDB
import com.aam.applydigitaltechnicalinterview.data.model.dao.HackerNewsDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceInject {

    @Provides
    @Singleton
    fun provideDatabaseCreationInstance(@ApplicationContext context: Context): HackerNewsDB {
        return Room.databaseBuilder(context, HackerNewsDB::class.java, "hacker_news_db")
            .fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideHitsDAO(database: HackerNewsDB): HackerNewsDAO {
        return database.hackerNewsDAO()
    }
}