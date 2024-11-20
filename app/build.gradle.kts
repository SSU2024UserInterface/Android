import java.util.Properties
import java.io.FileInputStream

// API 키 파일 로드
val apikeyProperties = Properties().apply {
    load(FileInputStream(rootProject.file("apikey.properties")))
}

plugins {
    id("com.android.application")
    id("com.google.gms.google-services") // Google Services 플러그인
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // AndroidX 기본 구성
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.activity:activity-ktx:1.7.2")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // 네비게이션
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")

    // 테스트 라이브러리
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Firebase
    implementation(platform("com.google.firebase:firebase-bom:33.5.1"))
    implementation("com.google.firebase:firebase-analytics-ktx")

    // Naver Maps
    implementation("com.naver.maps:map-sdk:3.19.1")

    // TimetableView
    implementation("com.github.tlaabs:TimetableView:1.0.3-fx1")
}
