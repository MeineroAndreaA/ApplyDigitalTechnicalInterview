package com.aam.applydigitaltechnicalinterview.presentation

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aam.applydigitaltechnicalinterview.data.navigation.ScreenRoutes
import com.aam.applydigitaltechnicalinterview.presentation.screens.home.HomeScreen
import com.aam.applydigitaltechnicalinterview.presentation.screens.web.WebViewScreen
import com.aam.applydigitaltechnicalinterview.presentation.theme.ui.DarkColorScheme
import com.aam.applydigitaltechnicalinterview.presentation.theme.ui.LightColorScheme
import com.aam.applydigitaltechnicalinterview.viewmodel.HackerNewsViewModel
import com.aam.applydigitaltechnicalinterview.viewmodel.NavigationViewModel

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    val navigationViewModel: NavigationViewModel = hiltViewModel()
    val hackerNewsViewModel: HackerNewsViewModel = hiltViewModel()
    navigationViewModel.navController = navController

    val isSystemInDarkTheme = isSystemInDarkTheme()

    val theme = if (isSystemInDarkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    CompositionLocalProvider(LocalContentColor provides theme.onSurface) {

        NavHost(navController = navController, startDestination = ScreenRoutes.Home.route)
        {
            composable(route = ScreenRoutes.Home.route)
            {
                val hitsList = hackerNewsViewModel._hits.collectAsState().value
                hitsList?.let { list ->
                    HomeScreen(
                        navigationViewModel = navigationViewModel,
                        hackerNewsViewModel = hackerNewsViewModel,
                        list
                    )
                }
            }
            composable(route = ScreenRoutes.WebDetail.route)
            {
                WebViewScreen(navController = navController, hackerNewsViewModel)
            }
        }

    }
}