package com.example.guap02.screen.element

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.guap02.R

/**
 * Composable для кнопки входа через Яндекс
 * @param onClick действие при нажатии
 * @author Сергей Рейнн (bulkabuka)
 */
@Composable
fun YandexButton(onClick: () -> Unit) {
    FilledTonalButton(
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(4.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.yandexid),
            contentDescription = "Yandex ID Logo",
            Modifier
                .width(64.dp)
                .padding(end = 12.dp)
        )
        Text(text = "Войти с Яндекс ID")
    }
}

@Preview
@Composable
fun YandexButtonPreview() {
    YandexButton(onClick = {})
}