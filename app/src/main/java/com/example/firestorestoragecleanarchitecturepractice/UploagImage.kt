package com.example.firestorestoragecleanarchitecturepractice

import android.net.Uri

class UploagImage(private val imageRespository : ImageRepositry) {
    suspend operator fun invoke(uri : Uri) = imageRespository.uploadImageToFirestore(uri)
}