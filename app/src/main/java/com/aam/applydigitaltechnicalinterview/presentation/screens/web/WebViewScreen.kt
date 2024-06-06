package com.aam.applydigitaltechnicalinterview.presentation.screens.web

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.aam.applydigitaltechnicalinterview.R
import com.aam.applydigitaltechnicalinterview.viewmodel.HackerNewsViewModel

@Composable
fun WebViewScreen(navController: NavController, hackerNewsViewModel: HackerNewsViewModel) {

    val url = hackerNewsViewModel._urlNew.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp)
    ) {
        TopAppBar(
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = stringResource(R.string.back_button_text)
                        )
                    }
                    Text(text = stringResource(R.string.back_button_text))
                }
            },
            backgroundColor = Color.White,
            elevation = AppBarDefaults.TopAppBarElevation
        )
        Spacer(modifier = Modifier.height(8.dp))

        AndroidView(
            factory = { context ->
                WebView(context).apply {
                    settings.javaScriptEnabled = true
                    webViewClient = WebViewClient()
                    loadUrl(url!!)
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}