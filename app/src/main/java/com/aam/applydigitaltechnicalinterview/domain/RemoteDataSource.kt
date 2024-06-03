package com.aam.applydigitaltechnicalinterview.domain

import com.aam.applydigitaltechnicalinterview.BuildConfig
import com.aam.applydigitaltechnicalinterview.data.core.AlgoliaNewsApiService
import com.aam.applydigitaltechnicalinterview.data.model.HackerNewsResponse

class RemoteDataSource(private val api: AlgoliaNewsApiService) : RemoteRepository {

    suspend fun getHackersNew(plataform: String = BuildConfig.PLATAFORM): ApiCallResult<HackerNewsResponse> {
        return handleApi { api.getHackerNews(plataform) }
    }
}