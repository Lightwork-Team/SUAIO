package com.example.guap02.API.Schedule.Model

import kotlinx.serialization.Serializable

@Serializable
data class Classrooms(
    val idClassrooms: Int,
    val Name: TimeClass,
    val Building: String?,
    val Vector: Int?
)