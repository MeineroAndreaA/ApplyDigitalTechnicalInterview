package com.aam.applydigitaltechnicalinterview.data

import com.aam.applydigitaltechnicalinterview.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitModule {

    private const val BASE_URL = BuildConfig.BASE_URL

    private val retrofitConfig by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: AlgoliaNewsApiService by lazy {
        retrofitConfig.create(AlgoliaNewsApiService::class.java)
    }

}