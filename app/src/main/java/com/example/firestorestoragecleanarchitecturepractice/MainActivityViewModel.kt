package com.example.firestorestoragecleanarchitecturepractice

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {
    fun uploadImage(uri: Uri) = viewModelScope.launch {
        useCases.uploadImage(uri)
    }

}