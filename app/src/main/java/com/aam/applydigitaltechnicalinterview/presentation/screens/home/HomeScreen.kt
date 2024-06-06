package com.aam.applydigitaltechnicalinterview.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.aam.applydigitaltechnicalinterview.R
import com.aam.applydigitaltechnicalinterview.data.model.response.HackerNewsResponse
import com.aam.applydigitaltechnicalinterview.data.model.response.Hits
import com.aam.applydigitaltechnicalinterview.viewmodel.HackerNewsViewModel
import com.aam.applydigitaltechnicalinterview.viewmodel.NavigationViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox


@Composable
fun HomeScreen(
    navigationViewModel: NavigationViewModel,
    hackerNewsViewModel: HackerNewsViewModel,
    response: HackerNewsResponse
) {

    val hitList = response.listHits.toMutableStateList()
    val isRefreshing by hackerNewsViewModel.isLoading.collectAsState()
    val removedItems = remember {
        mutableListOf<Int>()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing),
            onRefresh = {
                hackerNewsViewModel.loading.value = true
                hackerNewsViewModel.getAllHits()
            },
        ) {
            if (!isRefreshing) {
                LazyColumn {
                    items(
                        items = getCurrentItems(hitList.toMutableList(), removedItems),
                        key = { it.objectID!! }
                    ) { item ->

                        val delete = SwipeAction(
                            onSwipe = {
                                hitList -= item
                                removedItems.add(item.storyId!!.toInt())
                            },
                            icon = {
                                Text(
                                    text = stringResource(R.string.swipe_text_delete),
                                    color = Color.White,
                                    modifier = Modifier.padding(horizontal = 16.dp)
                                )
                            }, background = Color.Red,
                            isUndo = true
                        )

                        SwipeableActionsBox(
                            modifier = Modifier,
                            endActions = listOf(delete)
                        ) {
                            HitItem(hits = item) {
                                hackerNewsViewModel.urlNew.value =
                                    if (item.url.isNullOrEmpty()) item.storyUrl else item.url
                                navigationViewModel.navigateToWebView()
                            }
                        }
                    }
                }
            }
        }
    }
}

fun getCurrentItems(
    hitList: MutableList<Hits>,
    removedItems: MutableList<Int>
): MutableList<Hits> {
    return hitList.toMutableList().filter {
        it.storyId!!.toInt() !in removedItems
    }.toMutableList()
}
