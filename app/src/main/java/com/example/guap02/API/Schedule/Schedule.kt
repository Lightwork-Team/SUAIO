package com.example.guap02.API.Schedule

interface Schedule {
    suspend fun getByGroup(group: String): List<Schedule>
    suspend fun getByDayAndGroup(group: String, day: String): List<Schedule>
    suspend fun getByWeekAndGroup(group: String, week: String): List<Schedule>
    suspend fun getByDayAndWeek(group: String, day: String, week: String): List<Schedule>
}