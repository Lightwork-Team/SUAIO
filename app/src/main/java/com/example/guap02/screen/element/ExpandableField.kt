package com.example.guap02.screen.element

import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ExpandableField(
    items: List<String>,
    label: String
) {
    var isExpanded by remember { mutableStateOf(false) }
    var selectedValue by remember { mutableStateOf(items[0]) }
    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { isExpanded = it }
    ) {
        TextField(
            label = {
                Text(label)
            },
            value = selectedValue,
            onValueChange = { selectedValue = it },
            modifier = Modifier
                .focusable(true)
                .widthIn(max = 200.dp)
                .menuAnchor()
                .padding(8.dp),
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
            }
        )
        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false }) {
            items.forEach { group ->
                DropdownMenuItem(onClick = {
                    selectedValue = group
                }, text = { Text(group) })
            }
        }
    }
}

@Preview
@Composable
fun ExpandableFieldPreview() {
    val items = listOf("Item 1", "Item 2", "Item 3")
    ExpandableField(items, "Label")
}