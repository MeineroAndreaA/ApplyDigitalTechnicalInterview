package com.aam.applydigitaltechnicalinterview.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aam.applydigitaltechnicalinterview.data.mapperutils.Mapper
import com.aam.applydigitaltechnicalinterview.data.model.response.HackerNewsResponse
import com.aam.applydigitaltechnicalinterview.domain.local.LocalDataSource
import com.aam.applydigitaltechnicalinterview.domain.remote.ApiCallResult
import com.aam.applydigitaltechnicalinterview.domain.remote.RemoteDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HackerNewsViewModel @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : ViewModel() {

    private val hits = MutableStateFlow<HackerNewsResponse?>(null)
    val _hits: StateFlow<HackerNewsResponse?> = hits

    private val loading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = loading

    private val error = MutableStateFlow(Pair(false, ""))
    val weGotAnError: StateFlow<Pair<Boolean, String>> = error

    fun getAllHits() {
        viewModelScope.launch {
            when (val response = remoteDataSource.getHackersNew()) {
                is ApiCallResult.Error -> {

                }

                is ApiCallResult.Exception -> {
                    val hitsFromLocal = localDataSource.getAllHits()
                    val mappedHits = Mapper().hackerNewsResponseMapped(hitsFromLocal)
                    hits.value = mappedHits
                }

                is ApiCallResult.Success -> {
                    hits.value = response.data
                    localDataSource.insertAllHits(Mapper().mapperToHitEntity(response.data))
                }
            }
        }
    }
}