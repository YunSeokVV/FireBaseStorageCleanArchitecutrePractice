plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    //id ("com.google.dagger.hilt.android")
    id("dagger.hilt.android.plugin")

    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.firestorestoragecleanarchitecturepractice"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.firestorestoragecleanarchitecturepractice"
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

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Hilt dependencies
    implementation("com.google.dagger:hilt-android:2.50")
    kapt("com.google.dagger:hilt-compiler:2.50")


    //Firebase
    // Import the Firebase BoM as usual Make sure to use Firebase BoM v32.5.0 or higher
    implementation(platform("com.google.firebase:firebase-bom:32.7.2"))
    // No need to use the KTX libraries, everything is now in the main module
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-firestore")
    implementation("com.google.firebase:firebase-storage:20.3.0")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.16.0")

    // by viewModels 를 사용하기 위해 추가한 라이브러리
    implementation("androidx.activity:activity-ktx:1.5.0")

    // 로그를 보기 편하게 해주는 라이브러리
    implementation("com.orhanobut:logger:2.2.0")

    // 코루틴
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
}