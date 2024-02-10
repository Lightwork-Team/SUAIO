package com.example.guap02.auth.yandex.api.models

import kotlinx.serialization.Serializable

@Serializable
data class Phone(
    val id: Int,
    val number: String
)