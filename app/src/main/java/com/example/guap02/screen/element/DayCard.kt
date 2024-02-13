package com.example.guap02.screen.element

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.guap02.model.Lesson

@Composable
fun DayCard(lessons: List<Lesson>, label: String) {
    Card(Modifier.padding(8.dp).shadow(4.dp, shape = MaterialTheme.shapes.medium)) {
        Column(Modifier.fillMaxWidth()) {
            Row(Modifier.background(MaterialTheme.colorScheme.primary).fillMaxWidth().padding(8.dp)) {
                Text(label, style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.onPrimary)
            }
            lessons.forEach {
                LessonEntry(it)
            }
        }
    }
}

@Preview
@Composable
fun PreviewDayCard() {
    val lessons = listOf(
        Lesson(
            "",
            false,
            "Математика",
            listOf("Иванов И.И."),
            "Ауд. 101",
            "10:00-11:30",
            "Лекция",
            1
        ),
        Lesson(
            "10 минут",
            true,
            "Физика",
            listOf("Петров П.П."),
            "Ауд. 102",
            "11:40-13:10",
            "Лекция",
            2
        ),
        Lesson(
            "40 минут",
            true,
            "Информатика",
            listOf("Сидоров С.С.", "Сидорова С.С."),
            "Ауд. 103",
            "13:20-14:50",
            "Лекция",
            3
        )
    )
    DayCard(lessons, "Понедельник")
}