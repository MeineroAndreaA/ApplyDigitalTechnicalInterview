package com.aam.applydigitaltechnicalinterview.domain.local

import com.aam.applydigitaltechnicalinterview.data.model.entity.HitsEntity

interface LocalRepository {
    suspend fun insertAllHits(hits : List<HitsEntity>)
    suspend fun getAllHits() : List<HitsEntity>
}