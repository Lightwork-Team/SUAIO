package com.example.guap02.API.Schedule.Model

import kotlinx.serialization.Serializable

@Serializable
data class DaysWeek(
    val idDaysWeek: Int,
    val Name: String,
    val WeekEnd: Boolean
)