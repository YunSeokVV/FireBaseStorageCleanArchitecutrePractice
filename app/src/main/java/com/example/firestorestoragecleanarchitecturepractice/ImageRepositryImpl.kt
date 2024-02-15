package com.example.firestorestoragecleanarchitecturepractice

import android.net.Uri
import com.google.firebase.storage.StorageReference
import javax.inject.Inject
import javax.inject.Singleton
import com.example.firestorestoragecleanarchitecturepractice.Response.Failure
import com.example.firestorestoragecleanarchitecturepractice.Response.Success
import com.google.firebase.storage.FirebaseStorage
import com.orhanobut.logger.Logger
@Singleton
class ImageRepositryImpl @Inject constructor(
    private val storageReference : FirebaseStorage
) : ImageRepositry{
    override suspend fun uploadImageToFirestore(uri: Uri) = try {
        val storageRef = storageReference.reference

        var testImg = storageRef.child("test_image/testImage.jpg")
        val uploadTask = testImg.putFile(uri)
        uploadTask.addOnFailureListener {
            // Handle unsuccessful uploads
            Logger.v("upload failed ")

        }.addOnSuccessListener { taskSnapshot ->
            // taskSnapshot.metadata contains file metadata such as size, content-type, etc.
            Logger.v("upload complete")
        }

        Logger.v("Success called")

        Success(true)
    } catch (e: Exception) {
        Logger.v("e "+e.message)
        Failure(e)
    }


}