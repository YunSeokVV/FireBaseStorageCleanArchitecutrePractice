package com.example.firestorestoragecleanarchitecturepractice

import android.app.Application
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp
//Hilt를 사용하는 모든 앱은 @HiltAndroidApp으로 주석이 지정된 Application 클래스를 포함해야 합니다.
//@HiltAndroidApp은 애플리케이션 수준 종속 항목 컨테이너 역할을 하는 애플리케이션의 기본 클래스를 비롯하여 Hilt의 코드 생성을 트리거합니다.
@HiltAndroidApp
class FirestoreStorageCleanArchitectureApp : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}