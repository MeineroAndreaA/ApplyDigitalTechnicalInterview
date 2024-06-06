package com.aam.applydigitaltechnicalinterview.presentation.screens.home

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aam.applydigitaltechnicalinterview.R
import com.aam.applydigitaltechnicalinterview.data.model.response.Hits
import com.aam.applydigitaltechnicalinterview.presentation.screens.home.utils.formatDate
import com.aam.applydigitaltechnicalinterview.presentation.theme.ui.Grey40

@Composable
fun HitItem(hits: Hits, onItemClick: () -> Unit) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                if (!hits.url.isNullOrEmpty() || !hits.storyUrl.isNullOrEmpty()) {
                    onItemClick()
                } else Toast
                    .makeText(
                        context,
                        context.getString(R.string.url_not_found_toast),
                        Toast.LENGTH_LONG
                    )
                    .show()
            }
    ) {
        (if (hits.title.isNullOrEmpty()) hits.storyTitle else hits.title)?.let {
            Text(
                text = it,
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(bottom = 8.dp, start = 8.dp, top = 8.dp)
                    .fillMaxWidth()
            )
        }

        Text(
            text = "${hits.author} - ${formatDate(hits.createdAt.toString())}",
            fontSize = 17.sp,
            color = Grey40,
            modifier = Modifier
                .padding(bottom = 8.dp, start = 8.dp, top = 8.dp)
                .align(Alignment.Start)
                .fillMaxWidth()
        )

        Divider(
            color = Color.Black,
            thickness = 1.dp,
            startIndent = 8.dp,
            modifier = Modifier.fillMaxWidth()
        )
    }

}