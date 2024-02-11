package com.example.guap02.API.Schedule.Model

import kotlinx.serialization.Serializable

@Serializable
data class Teacher(
    val idTeacher: Int,
    val Surname: String,
    val Name: String,
    val Patronimic: String,
    val email: String?,
    val phone: String?,
    val portrait: String //Возможно другой тип
)