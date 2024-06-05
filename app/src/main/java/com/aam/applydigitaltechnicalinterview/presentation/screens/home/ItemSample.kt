package com.aam.applydigitaltechnicalinterview.presentation.screens.home

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aam.applydigitaltechnicalinterview.data.model.response.Hits
import com.aam.applydigitaltechnicalinterview.presentation.screens.home.utils.formatDate
import com.aam.applydigitaltechnicalinterview.presentation.theme.Grey40

@Composable
fun ItemSample(hits: Hits) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { }
    ) {
        (if (hits.title.isNullOrEmpty()) hits.storyTitle else hits.title)?.let {
            Text(
                text = it,
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(bottom = 8.dp, start = 8.dp, top = 8.dp)
            )
        }

        Text(
            text = "${hits.author} - ${formatDate(hits.createdAt.toString())}",
            fontSize = 17.sp,
            color = Grey40,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 8.dp, start = 8.dp, top = 8.dp)
        )

        Divider(
            color = Color.Black,
            thickness = 1.dp,
            modifier = Modifier.padding(top = 8.dp)
        )
    }

}