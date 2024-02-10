package com.example.guap02.auth.yandex.api.models

import kotlinx.serialization.Serializable

@Serializable
data class ResponseData(
    val id: String,
    val login: String,
    val client_id: String,
    val display_name: String,
    val real_name: String,
    val first_name: String,
    val last_name: String,
    val sex: String,
    val default_email: String,
    val emails: List<String>,
    val birthday: String,
    val default_avatar_id: String,
    val is_avatar_empty: Boolean,
    val default_phone: Phone,
    val psuid: String
)