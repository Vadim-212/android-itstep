package kz.step.stepeducation

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.RequiresApi

class PhotoActivity : AppCompatActivity() {
    var imageView: ImageView? = null
    var takePhotoButton: Button? = null
    val REQUEST_IMAGE_CAPTURE = 1

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)
        initializeViews()
        initializeListeners()
    }

    fun initializeViews() {
        imageView = findViewById(R.id.imageview_activity_photo_image)
        takePhotoButton = findViewById(R.id.button_activity_photo_take_image)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun initializeListeners() {
        takePhotoButton!!.setOnClickListener {
            if(checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(cameraIntent, 1)
            } else {
                requestPermissions(Array<String>(1){android.Manifest.permission.CAMERA}, 101)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imageView?.setImageBitmap(imageBitmap)
        }
    }
}