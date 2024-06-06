package com.aam.applydigitaltechnicalinterview.data.core

import com.aam.applydigitaltechnicalinterview.data.model.response.HackerNewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AlgoliaNewsApiService {

    @GET("search_by_date")
    suspend fun getHackerNews(@Query("query") plataformQuery : String) : Response<HackerNewsResponse>
}