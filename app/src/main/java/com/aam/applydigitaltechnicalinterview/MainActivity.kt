package com.aam.applydigitaltechnicalinterview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aam.applydigitaltechnicalinterview.data.core.RetrofitModule
import com.aam.applydigitaltechnicalinterview.domain.remote.RemoteDataSource
import com.aam.applydigitaltechnicalinterview.presentation.theme.ApplyDigitalTechnicalInterviewTheme
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        runBlocking { RemoteDataSource(RetrofitModule.api).getHackersNew() }
        enableEdgeToEdge()
        setContent {
            ApplyDigitalTechnicalInterviewTheme {
            }
        }
    }
}

