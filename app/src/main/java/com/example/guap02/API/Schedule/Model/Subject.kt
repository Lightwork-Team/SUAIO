package com.example.guap02.API.Schedule.Model

import kotlinx.serialization.Serializable

@Serializable
data class Subject(
    val idSubject: Int,
    val Name: String
)