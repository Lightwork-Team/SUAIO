plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("plugin.serialization") version "1.5.10"
}

android {
    namespace = "com.example.guap02"
    compileSdk = 34

    defaultConfig {
        manifestPlaceholders["YANDEX_CLIENT_ID"] = "c414f56d11fe4b8996750b271136eb54"
        addManifestPlaceholders(mapOf(
            "VKIDRedirectHost" to "vk.com", // обычно vk.com
            "VKIDRedirectScheme" to "vk51848658", // обычно vk{ID приложения}
            "VKIDClientID" to "51848658", //ZhMfj1959jhc9n6wqWgT
            "VKIDClientSecret" to "ZhMfj1959jhc9n6wqWgT" //0b62da6f0b62da6f0b62da6fba0875ffbd00b620b62da6f6edd6ac2c18360a1a40efaf6
        ))
        applicationId = "com.example.yaauthdemo"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8

        isCoreLibraryDesugaringEnabled = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.4") //Нужно для работы vk onetap
    //Авторизация
    implementation ("com.yandex.android:authsdk:3.1.0")
    implementation("com.vk.id:onetap-compose:1.2.0")
    //http ktor

    implementation ("io.ktor:ktor-client-core:2.3.4")
    implementation ("io.ktor:ktor-client-json:2.3.3")
    implementation ("io.ktor:ktor-client-serialization:2.3.3")
    implementation ("io.ktor:ktor-client-okhttp:2.3.4")
    implementation ("io.ktor:ktor-client-content-negotiation:2.3.3")
    implementation ("io.ktor:ktor-serialization-kotlinx-json:2.3.3")

    //Криптография
    implementation("dev.whyoleg.cryptography:cryptography-core:0.2.0")
    implementation("dev.whyoleg.cryptography:cryptography-provider-jdk:0.2.0")

    implementation("io.coil-kt:coil-compose:2.5.0")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}