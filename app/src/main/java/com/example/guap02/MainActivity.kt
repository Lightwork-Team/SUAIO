package com.example.guap02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.guap02.screen.Auth
import com.example.guap02.screen.News
import com.example.guap02.screen.Overview
import com.example.guap02.screen.Settings
import com.example.guap02.ui.theme.Guap02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Guap02Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SuaioApp()
                }
            }
        }
    }
}

/**
 * Входная точка в приложение
 * @author Сергей Рейнн (bulkabuka)
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuaioApp() {
    Guap02Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val screens = mapOf(
                "Обзор" to Icons.Rounded.DateRange,
                "Новости" to Icons.Rounded.Email,
                "Настройки" to Icons.Rounded.Settings
            )
            var currentScreen by remember { mutableStateOf("Обзор") }
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(currentScreen) }
                    )
                },
                bottomBar = {
                    NavigationBar {
                        screens.forEach { screen ->
                            NavigationBarItem(
                                icon = {
                                    Icon(
                                        imageVector = screen.value,
                                        contentDescription = null
                                    )
                                },
                                label = { Text(screen.key) },
                                selected = currentScreen == screen.key,
                                onClick = { currentScreen = screen.key }
                            )
                        }
                    }
                }
            ) { innerPadding ->
                Column(Modifier.padding(innerPadding)) {
                    when (currentScreen) {
                        "Обзор" -> Overview()
                        "Новости" -> News()
                        "Настройки" -> Settings()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SuaioAppPreview() {
    SuaioApp()
}