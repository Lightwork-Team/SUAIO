package com.example.guap02.screen.tabs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.guap02.R
import com.example.guap02.screen.element.VkButton
import com.example.guap02.screen.element.YandexButton

/**
 * Вкладка входа в приложение
 * @author Сергей Рейнн (bulkabuka)
 */
@Composable
fun LoginTab() {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(1f),
            value = login,
            onValueChange = { login = it },
            label = { Text(text = "Электронная почта") },
            trailingIcon = {
                IconButton(onClick = { login = "" }) {
                    Icon(imageVector = Icons.Rounded.Clear, contentDescription = "Clear email")
                }
            }
        )
        TextField(
            maxLines = 1,
            value = password,
            modifier = Modifier.fillMaxWidth(1f),
            onValueChange = { password = it },
            label = { Text(text = "Пароль", overflow = TextOverflow.Ellipsis, maxLines = 1) },
            trailingIcon = {
                IconButton(onClick = { password = "" }) {
                    Icon(
                        imageVector = Icons.Rounded.Clear,
                        contentDescription = "Clear password"
                    )
                }
            }
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(4.dp)
        ) {
            Text(text = "Войти")
        }
        Spacer(modifier = Modifier.weight(1f))
        YandexButton {
        }
        VkButton {
        }
    }
}

@Preview(device = "id:pixel_7_pro")
@Composable
fun LoginTabPreview() {
    LoginTab()
}