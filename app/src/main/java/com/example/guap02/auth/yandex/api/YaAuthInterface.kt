package com.example.guap02.auth.yandex.api

import com.example.guap02.auth.yandex.api.models.ResponseData
import com.yandex.authsdk.YandexAuthResult
import com.yandex.authsdk.YandexAuthToken

interface YaAuthInterface {
    suspend fun getUserInfo(authHeader: String, jwtKey: String): ResponseData

    fun handleResult(result: YandexAuthResult): YandexAuthToken?
}