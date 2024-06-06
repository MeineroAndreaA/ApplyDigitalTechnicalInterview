package com.aam.applydigitaltechnicalinterview.domain.local

import com.aam.applydigitaltechnicalinterview.data.model.dao.HackerNewsDAO
import com.aam.applydigitaltechnicalinterview.data.model.entity.HitsEntity
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val hitsDao: HackerNewsDAO) : LocalRepository {
    override suspend fun insertAllHits(hits: List<HitsEntity>) = hitsDao.insertAllHits(hits)


    override suspend fun getAllHits(): List<HitsEntity> {
        return hitsDao.getAllHits()
    }
}