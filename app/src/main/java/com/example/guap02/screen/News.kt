package com.example.guap02.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.guap02.screen.element.NewsEntry

@Composable
fun News() {
    LazyColumn {
        items(10) {
            NewsEntry()
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun NewsPreview() {
    News()
}