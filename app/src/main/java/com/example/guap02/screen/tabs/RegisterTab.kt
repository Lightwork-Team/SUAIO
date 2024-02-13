package com.example.guap02.screen.tabs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.guap02.screen.element.VkButton
import com.example.guap02.screen.element.YandexButton

/**
 * Вкладка регистрации
 * @author Сергей Рейнн (bulkabuka)
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterTab() {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordRepeat by remember { mutableStateOf("") }
    var dropdownOpen by remember { mutableStateOf(false) }
    val options = listOf("Test", "Test", "Test")
    var selectedOptionText by remember { mutableStateOf(options[0]) }
    var checked by remember { mutableStateOf(false) }
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

        Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
            TextField(
                maxLines = 1,
                modifier = Modifier.weight(1f),
                value = password,
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
            TextField(
                maxLines = 1,
                modifier = Modifier.weight(1f),
                value = passwordRepeat,
                onValueChange = { passwordRepeat = it },
                label = {
                    Text(
                        text = "Подтверждение",
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                },
                trailingIcon = {
                    IconButton(onClick = { passwordRepeat = "" }) {
                        Icon(
                            imageVector = Icons.Rounded.Clear,
                            contentDescription = "Clear password"
                        )
                    }
                }
            )
        }

        ExposedDropdownMenuBox(
            expanded = dropdownOpen,
            onExpandedChange = { dropdownOpen = it },
        ) {
            TextField(
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth(),
                readOnly = true,
                value = selectedOptionText,
                onValueChange = {},
                label = { Text("Выберите группу") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = dropdownOpen) },
                colors = ExposedDropdownMenuDefaults.textFieldColors()

            )
            ExposedDropdownMenu(
                expanded = dropdownOpen,
                onDismissRequest = { dropdownOpen = false }) {
                options.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(selectionOption) },
                        onClick = {
                            selectedOptionText = selectionOption
                            dropdownOpen = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                    )
                }
            }
        }
        Row(Modifier.fillMaxWidth()) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
            ) {
                Text("Регистрация", maxLines = 1, overflow = TextOverflow.Ellipsis)
            }
            OutlinedButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
            ) {
                Text("Соглашение", maxLines = 1, overflow = TextOverflow.Ellipsis)
            }
        }

        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = checked, onCheckedChange = { checked = it })
            Text("Я согласен с условиями", maxLines = 1, overflow = TextOverflow.Ellipsis)
        }

        Spacer(modifier = Modifier.weight(1f))
        YandexButton {
        }
        VkButton {
        }
    }
}

@Preview
@Composable
fun RegisterTabPreview() {
    RegisterTab()
}