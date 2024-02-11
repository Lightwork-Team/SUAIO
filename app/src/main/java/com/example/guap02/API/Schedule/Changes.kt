package com.example.guap02.API.Schedule

import com.example.guap02.API.Schedule.Model.ScheduleChanges

interface Changes {
    suspend fun get(group: String): List<ScheduleChanges>
}