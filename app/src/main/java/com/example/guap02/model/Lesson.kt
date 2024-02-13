package com.example.guap02.model

data class Lesson(
    var breakTime: String = "10 минут",
    var showBreak: Boolean = true,
    var lessonName: String = "Математика",
    var teachers: List<String> = listOf("Иванов Иван Иванович", "Петров Петр Петрович"),
    var room: String = "101",
    var time: String = "10:10 - 11:40",
    var type: String = "Лекция",
    var number: Int = 1
)