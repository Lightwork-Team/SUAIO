package com.example.guap02.screen

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.guap02.model.Lesson
import com.example.guap02.screen.element.DayCard
import com.example.guap02.screen.element.ExpandableField
import com.example.guap02.screen.element.LessonEntry
import com.example.guap02.screen.element.NewsEntry

@Composable
fun Overview() {
    val groups = listOf("Группа 1", "Группа 2", "Группа 3", "Авто")
    val days = listOf(
        "Понедельник",
        "Вторник",
        "Среда",
        "Четверг",
        "Пятница",
        "Суббота",
        "Воскресенье",
        "Авто"
    )
    val weekTypes = listOf("Числитель", "Знаменатель", "Авто")
    val scrollFilterState = rememberScrollState(0)
    Column {
        LazyRow(
            modifier = Modifier
                .scrollable(orientation = Orientation.Horizontal, state = scrollFilterState)
        ) {
            item {
                ExpandableField(groups, "Группа")
                ExpandableField(days, "День недели")
                ExpandableField(weekTypes, "Тип недели")
            }
        }
        LazyColumn {
            items(10) {
                DayCard(listOf(Lesson(), Lesson(), Lesson()), "Понедельник")
            }
        }
    }
}

@Preview(
    device = "spec:width=1440px,height=3120px,dpi=560", showSystemUi = true,
    showBackground = true
)
@Composable
fun OverviewPreview() {
    Overview()
}