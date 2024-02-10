package com.example.guap02.auth.encryption

import android.util.Log
import dev.whyoleg.cryptography.CryptographyProvider
import dev.whyoleg.cryptography.algorithms.digest.SHA512
import dev.whyoleg.cryptography.operations.hash.Hasher

class EncryptionImpl : EncryptionInterface {
    override suspend fun EncryptToken(Token: String): ByteArray {
        val provider = CryptographyProvider.Default
        val hasher: Hasher = provider.get(SHA512).hasher()
        val hash = hasher.hash(Token.encodeToByteArray()) //YA1
        Log.e("HASH", hash.joinToString("") { "%02x".format(it) }) //LOG: Для проверки ключей
        return hash
    }

    override fun CheckEncryptedToken(UserToken: String, ServerToken: String): Boolean {
        return UserToken.contentEquals(ServerToken)
    }
}