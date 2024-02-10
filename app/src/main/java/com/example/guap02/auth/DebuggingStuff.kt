package com.example.guap02.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.guap02.auth.encryption.EncryptionImpl
import com.example.guap02.auth.yandex.api.models.ResponseData
import kotlinx.coroutines.launch

@Composable
fun DisplayYandexUserInfo(user: ResponseData?, token: String) {
    user?.let {
        Spacer(modifier = Modifier.height(8.dp))
        Text("С возращением ${it.display_name}", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "Номер телефона: ${it.default_phone.number}",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text("Почта: ${it.default_email}", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text("День рождения: ${it.birthday}", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Image(
            painter = rememberAsyncImagePainter("https://avatars.yandex.net/get-yapic/${it.default_avatar_id}/islands-200"),
            contentDescription = null,
            modifier = Modifier
                .height(120.dp)
                .width(120.dp),
            contentScale = ContentScale.Crop
        )
        CryptoTest(token, modifier = Modifier.height(70.dp))
    }
}

@Composable
fun CryptoTest(token: String, modifier: Modifier = Modifier) {
    val coroutineScope = rememberCoroutineScope()
    var shaKey by remember { mutableStateOf<String>("") }

    LaunchedEffect(token) {
        coroutineScope.launch {
            shaKey = EncryptionImpl().EncryptToken(token).joinToString("") { "%02x".format(it) }
        }
    }

    if (shaKey.isNotEmpty()) {
        Text("SHA Key: $shaKey", modifier = modifier)
    }
}