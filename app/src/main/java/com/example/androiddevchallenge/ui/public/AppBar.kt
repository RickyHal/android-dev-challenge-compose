package com.example.androiddevchallenge.ui.public

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun AppBar(title: String) {
    TopAppBar(elevation = 0.dp) {
        Text(text = title, style = MaterialTheme.typography.h5,
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight(Alignment.CenterVertically),
            color = androidx.compose.ui.graphics.Color.White,
            textAlign = TextAlign.Center)
    }
}