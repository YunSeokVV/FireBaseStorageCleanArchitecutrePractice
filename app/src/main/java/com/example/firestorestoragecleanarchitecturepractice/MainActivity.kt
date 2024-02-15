package com.example.firestorestoragecleanarchitecturepractice

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var imageView : ImageView
    private val startForResult =
        registerForActivityResult(ActivityResultContracts.GetContent()) {
            it?.let { Glide.with(this).load(it).into(imageView) }
            it?.let { uri -> uploadtImage(uri) }
        }

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Logger.addLogAdapter(AndroidLogAdapter())
        imageView = findViewById(R.id.image)

        imageView.setOnClickListener{
            startForResult.launch("image/*")
        }

    }

    fun uploadtImage(uri : Uri){
        viewModel.uploadImage(uri)
    }

}