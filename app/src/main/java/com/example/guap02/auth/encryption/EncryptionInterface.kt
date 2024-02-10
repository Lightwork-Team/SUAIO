package com.example.guap02.auth.encryption

interface EncryptionInterface {
    suspend fun EncryptToken(Token: String): ByteArray

    fun CheckEncryptedToken(
        UserToken: String,
        ServerToken: String
    ): Boolean //Проверка совпадения ключа сервера и пользователя
}