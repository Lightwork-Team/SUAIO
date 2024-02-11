package com.example.guap02.API.Schedule

import com.example.guap02.API.Schedule.Model.Teacher

interface Teachers {
    suspend fun getByFullName(name: String, surname: String, patronimic: String): Teacher
    suspend fun getList(): List<Teacher>
}