package com.example.guap02.auth.yandex.api

import com.example.guap02.auth.yandex.api.models.ResponseData
import com.yandex.authsdk.YandexAuthResult
import com.yandex.authsdk.YandexAuthToken
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json
import io.ktor.http.HttpHeaders
import io.ktor.http.isSuccess

class YandexAuthImpl : YaAuthInterface {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json()
        }

    }
    override fun handleResult(result: YandexAuthResult): YandexAuthToken? {
        return when (result) {
            is YandexAuthResult.Success -> result.token
            is YandexAuthResult.Failure -> null
            YandexAuthResult.Cancelled -> null
        }
    }

    override suspend fun getUserInfo(authHeader: String, jwtKey: String): ResponseData {
        val response: HttpResponse = client.get("https://login.yandex.ru/info?&format=json") {
            header(HttpHeaders.Authorization, "Bearer $authHeader")
            parameter("jwt_secret", jwtKey)
        }
        val responseData: ResponseData = response.body()
        if (response.status.isSuccess()) {
            return responseData
        } else {
            throw Exception("Failed to fetch data. Status code: ${response.status}")
        }
    }
}