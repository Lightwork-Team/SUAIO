package com.example.guap02.API.Schedule.Model

import kotlinx.serialization.Serializable

@Serializable
data class TimeClass(
    val idTimeClasses: Int,
    val beginTime: String, //Тут timestamp
    val endTime: String, //Тут timestamp
    val number: Int
)