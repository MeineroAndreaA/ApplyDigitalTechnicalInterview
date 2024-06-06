package com.aam.applydigitaltechnicalinterview.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.aam.applydigitaltechnicalinterview.data.navigation.ScreenRoutes

class NavigationViewModel : ViewModel() {

    lateinit var navController : NavController

    fun navigateToWebView()
    {
        navController.navigate(ScreenRoutes.WebDetail.route)
    }

    fun backToHome()
    {
        navController.popBackStack()
        navController.navigate(ScreenRoutes.Home.route)
        navController.popBackStack()
    }

}