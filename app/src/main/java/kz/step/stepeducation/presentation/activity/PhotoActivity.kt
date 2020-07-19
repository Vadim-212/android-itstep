package kz.step.stepeducation.presentation.activity

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_photo.*
import kz.step.stepeducation.R
import kz.step.stepeducation.domain.usecase.CameraHelper

class PhotoActivity : AppCompatActivity() {
    val REQUEST_IMAGE_CAPTURE = 1
    val cameraHelper = CameraHelper(this, REQUEST_IMAGE_CAPTURE)

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)
        initializeListeners()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun initializeListeners() {
        button_activity_photo_take_image!!.setOnClickListener {
            cameraHelper.startCamera()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imageview_activity_photo_image?.setImageBitmap(imageBitmap)
        }
    }
}