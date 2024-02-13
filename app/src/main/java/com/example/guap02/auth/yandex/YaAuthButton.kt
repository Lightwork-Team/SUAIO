package com.example.guap02.auth.yandex

import android.annotation.SuppressLint
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.guap02.R
import com.example.guap02.auth.DisplayYandexUserInfo
import com.example.guap02.auth.yandex.api.YandexAuthImpl
import com.example.guap02.auth.yandex.api.models.ResponseData
import com.yandex.authsdk.YandexAuthLoginOptions
import com.yandex.authsdk.YandexAuthOptions
import com.yandex.authsdk.YandexAuthSdk
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @return Yandex Auth Butto
 */
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun YaAuth() {
    val context = LocalContext.current
    val sdk = YandexAuthSdk.create(YandexAuthOptions(context))
    val loginOptions = YandexAuthLoginOptions()
    var token by remember { mutableStateOf("") }
    var jwt by remember { mutableStateOf("") }
    var user by remember { mutableStateOf<ResponseData?>(null) }
    val YandexAuth = YandexAuthImpl()

    val launcher = rememberLauncherForActivityResult(contract = sdk.contract) { result ->
        CoroutineScope(Dispatchers.IO).launch {
            YandexAuth.handleResult(result)?.let { res ->
                token = res.value
                jwt = sdk.getJwt(res)
                if (jwt.isNotBlank() && token.isNotBlank()) {
                    user = YandexAuth.getUserInfo(token, jwt)
                }
            }
        }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Button(
            onClick = { launcher.launch(loginOptions) }
        ) {
            Image(
                painter = painterResource(id = R.drawable.yandexid),
                contentDescription = "Image",
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
            )
        }

        DisplayYandexUserInfo(user = user, token = token)
    }
}

@Preview
@Composable
fun YaAuthPreview() {
    YaAuth()
}