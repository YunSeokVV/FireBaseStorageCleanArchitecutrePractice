package com.example.firestorestoragecleanarchitecturepractice

import com.google.firebase.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.storage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.launch

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideStorageRef() = Firebase.storage

    @Provides
    fun provideStorageRepository(storageReference: FirebaseStorage) : ImageRepositry = ImageRepositryImpl(
        storageReference
    )

    @Provides
    fun provideUseCases(repo: ImageRepositry) = UseCases(uploadImage = UploagImage(repo))
}