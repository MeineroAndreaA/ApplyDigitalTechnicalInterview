package com.aam.applydigitaltechnicalinterview.data.navigation

sealed class ScreenRoutes (val route : String) {
    data object Home : ScreenRoutes("_home")
    data object WebDetail : ScreenRoutes("_webView")

}