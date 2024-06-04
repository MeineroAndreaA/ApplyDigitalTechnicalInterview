package com.aam.applydigitaltechnicalinterview.viewmodel

import androidx.lifecycle.ViewModel
import com.aam.applydigitaltechnicalinterview.domain.remote.RemoteDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HackerNewsViewModel @Inject constructor(val remoteDataSource: RemoteDataSource) : ViewModel() {
}