import java.util.Properties
import java.io.FileInputStream

// API 키 파일 로드
val apikeyProperties = Properties().apply {
    load(FileInputStream(rootProject.file("apikey.properties")))
}

plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.mohassu"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mohassu"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // manifestPlaceholders에 NAVER_MAPS_CLIENT_ID 설정
        manifestPlaceholders["NAVER_MAPS_CLIENT_ID"] = apikeyProperties["NAVER_MAPS_CLIENT_ID"].toString()
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
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Firebase
    implementation(platform("com.google.firebase:firebase-bom:33.5.1"))
    implementation("com.google.firebase:firebase-analytics")

    // Naver Maps
    implementation("com.naver.maps:map-sdk:3.19.1")

    implementation ("com.github.tlaabs:TimetableView:1.0.3-fx1")
}