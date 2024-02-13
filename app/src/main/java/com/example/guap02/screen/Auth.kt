package com.example.guap02.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.guap02.screen.element.Alert
import com.example.guap02.screen.element.VkButton
import com.example.guap02.screen.element.YandexButton
import com.example.guap02.screen.tabs.LoginTab
import com.example.guap02.screen.tabs.RegisterTab

/**
 * Экран авторизации
 * @author Сергей Рейнн (bulkabuka)
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Auth() {
    var selectedTab by remember { mutableIntStateOf(0) }
    Column {
        PrimaryTabRow(selectedTabIndex = selectedTab, Modifier.padding(bottom = 12.dp)) {
            Tab(selected = selectedTab == 0, onClick = { selectedTab = 0 }) {
                Text("Регистрация", Modifier.padding(12.dp))
            }
            Tab(selected = selectedTab == 1, onClick = { selectedTab = 1 }) {
                Text(text = "Авторизация", Modifier.padding(12.dp))
            }
        }
        Column(Modifier.padding(24.dp)) {
            Alert(
                icon = Icons.Rounded.AccountCircle,
                text = "Добро пожаловать в SUAIO! Войдите или зарегистрируйтесь.",
                Modifier.padding(bottom = 24.dp),
                iconColor = MaterialTheme.colorScheme.onPrimaryContainer,
                backgroundColor = MaterialTheme.colorScheme.primaryContainer
            )

            when (selectedTab) {
                0 -> RegisterTab()
                1 -> LoginTab()
            }
        }
    }
}

@Preview(device = "id:pixel_7_pro")
@Composable
fun AuthPreview() {
    Auth()
}