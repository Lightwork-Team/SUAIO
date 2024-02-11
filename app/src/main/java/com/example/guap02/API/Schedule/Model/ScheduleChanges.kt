package com.example.guap02.API.Schedule.Model

import kotlinx.serialization.Serializable

@Serializable
data class ScheduleChanges(
    val idScheduleChange: Int,
    val timeClasses: TimeClass,
    val subject: Subject,
    val forDate: String, //Тут timestamp
    val Teacher: TeacherClassrooms
)