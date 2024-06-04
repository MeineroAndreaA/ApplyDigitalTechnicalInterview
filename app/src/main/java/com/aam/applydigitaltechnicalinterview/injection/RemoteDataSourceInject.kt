package com.aam.applydigitaltechnicalinterview.injection

import com.aam.applydigitaltechnicalinterview.data.core.AlgoliaNewsApiService
import com.aam.applydigitaltechnicalinterview.data.core.RetrofitModule
import com.aam.applydigitaltechnicalinterview.domain.remote.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceInject {

    @Provides
    @Singleton
    fun provideApiService(): AlgoliaNewsApiService {
        return RetrofitModule.api
    }

    @Provides
    @Singleton
    fun provideRemoteDataSourceInstance(api: AlgoliaNewsApiService): RemoteDataSource {
        return RemoteDataSource(api)
    }

}