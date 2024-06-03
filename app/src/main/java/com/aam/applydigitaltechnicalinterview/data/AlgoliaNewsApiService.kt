package com.aam.applydigitaltechnicalinterview.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AlgoliaNewsApiService {

    @GET
    suspend fun getHackerNews(@Query("query") plataformQuery : String) : Response<HackerNewsResponse>
}