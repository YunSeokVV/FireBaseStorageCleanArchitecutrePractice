package com.example.firestorestoragecleanarchitecturepractice

//코틀린 out과 in에 관한 키워드 정리
//https://ppeper.github.io/kotlin/kotlin-generic/
sealed class Response<out T> {
    object Loading : Response<Nothing>()

    data class Success<out T>(
        val data : T
    ) : Response<T>()

    data class Failure(
        val e : Exception?
    ) : Response<Nothing>()
}