package com.aam.applydigitaltechnicalinterview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.aam.applydigitaltechnicalinterview.presentation.theme.ApplyDigitalTechnicalInterviewTheme
import com.aam.applydigitaltechnicalinterview.viewmodel.HackerNewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApplyDigitalTechnicalInterviewTheme {
            }
        }
    }
}

