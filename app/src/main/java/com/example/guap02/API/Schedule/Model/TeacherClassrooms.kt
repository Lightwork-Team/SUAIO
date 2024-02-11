package com.example.guap02.API.Schedule.Model

import kotlinx.serialization.Serializable

@Serializable
data class TeacherClassrooms(
    val Classrooms: Classrooms,
    val teacher: Teacher,
    val subgroup: Int
)