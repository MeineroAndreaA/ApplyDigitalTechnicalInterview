package com.aam.applydigitaltechnicalinterview.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissState
import androidx.compose.material3.DismissValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.aam.applydigitaltechnicalinterview.R
import com.aam.applydigitaltechnicalinterview.data.model.response.HackerNewsResponse
import com.aam.applydigitaltechnicalinterview.data.model.response.Hits
import com.aam.applydigitaltechnicalinterview.viewmodel.HackerNewsViewModel
import com.aam.applydigitaltechnicalinterview.viewmodel.NavigationViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.delay
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
