package com.aam.applydigitaltechnicalinterview.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.aam.applydigitaltechnicalinterview.data.model.response.HackerNewsResponse
import com.aam.applydigitaltechnicalinterview.viewmodel.HackerNewsViewModel
import com.aam.applydigitaltechnicalinterview.viewmodel.NavigationViewModel

@Composable
fun HomeScreen(
    navigationViewModel: NavigationViewModel,
    hackerNewsViewModel: HackerNewsViewModel,
    hitsList: HackerNewsResponse
) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        LazyColumn {
            items(hitsList.listHits.size) {
                ItemSample(hits = hitsList.listHits[it])
            }
        }
    }
}