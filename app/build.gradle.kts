plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id ("kotlin-kapt") // Añadir para usar kapt correctamente en Kotlin
}

android {
    namespace = "com.example.clase18_10"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.clase18_10"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation("androidx.recyclerview:recyclerview:1.2.1")

    val room_version = "2.6.1"

    // Room runtime
    implementation("androidx.room:room-runtime:$room_version")

    // Para procesamiento de anotaciones con Kotlin
    kapt("androidx.room:room-compiler:$room_version")

    // Soporte para Kotlin Extensions y Corrutinas
    implementation("androidx.room:room-ktx:$room_version")
}
