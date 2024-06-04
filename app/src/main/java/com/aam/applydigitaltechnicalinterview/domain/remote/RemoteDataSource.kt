package com.aam.applydigitaltechnicalinterview.domain.remote

import com.aam.applydigitaltechnicalinterview.BuildConfig
import com.aam.applydigitaltechnicalinterview.data.core.AlgoliaNewsApiService
import com.aam.applydigitaltechnicalinterview.data.model.response.HackerNewsResponse
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val api: AlgoliaNewsApiService) : RemoteRepository {

    suspend fun getHackersNew(plataform: String = BuildConfig.PLATAFORM): ApiCallResult<HackerNewsResponse> {
        return handleApi { api.getHackerNews(plataform) }
    }
}