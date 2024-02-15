package com.example.firestorestoragecleanarchitecturepractice

import android.net.Uri
typealias UploadBookResponse = Response<Boolean>

interface ImageRepositry {
    suspend fun uploadImageToFirestore(uri : Uri): UploadBookResponse
}