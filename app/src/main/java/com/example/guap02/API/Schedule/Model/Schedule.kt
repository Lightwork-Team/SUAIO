package com.example.guap02.API.Schedule.Model

import kotlinx.serialization.Serializable

@Serializable
data class Schedule(
    val timeClasses: TimeClass,
    val DayWeeks: DaysWeek,
    val TypeWeek: TypeWeek, //Тут timestamp
    val Subjects: Subject,
    val Teachers: List<TeacherClassrooms>
)