package kz.step.stepeducation.activity

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kz.step.stepeducation.R
import java.io.ByteArrayOutputStream
import java.io.IOException


class UserRegistrationActivity : AppCompatActivity() {
    var selfieImageView: ImageView? = null
    var firstNameEditText: EditText? = null
    var surnameEditText: EditText? = null
    var fillInfoButton: Button? = null
    private var cameraStubBitmap: Bitmap? = null
    private val REQUEST_IMAGE_CAPTURED = 1

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_registration)

        initializeViews()
        initializeListeners()
    }

    fun initializeViews() {
        selfieImageView = findViewById(R.id.imageview_activity_user_registration_user_selfie)
        firstNameEditText = findViewById(R.id.edittext_activity_user_registration_user_first_name)
        surnameEditText = findViewById(R.id.edittext_activity_user_registration_user_surname)
        fillInfoButton = findViewById(R.id.button_activity_user_registration_fill_info)

        cameraStubBitmap = getBitmapFromAssets("camera_stub_image.png")
        if(cameraStubBitmap != null) {
            selfieImageView?.setImageBitmap(cameraStubBitmap)
        }

    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun initializeListeners() {
        selfieImageView?.setOnClickListener {
            if(checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(cameraIntent, REQUEST_IMAGE_CAPTURED)
            } else {
                requestPermissions(Array<String>(1){ android.Manifest.permission.CAMERA }, 101)
            }
        }

        fillInfoButton?.setOnClickListener {
            val bitmapDrawable = selfieImageView?.drawable as BitmapDrawable
            val bitmap = bitmapDrawable.bitmap

            if(bitmap.sameAs(cameraStubBitmap)) {
                Toast.makeText(this, "Невозможно заполнить данные\nИзображение не заполнено!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(firstNameEditText?.text.isNullOrEmpty()) {
                Toast.makeText(this, "Невозможно заполнить данные\nИмя не заполнено!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(surnameEditText?.text.isNullOrEmpty()) {
                Toast.makeText(this, "Невозможно заполнить данные\nФамилия не заполнена!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, RegisteredUserInfoActivity::class.java)
            intent.putExtra("userSelfie", drawableToByteArray(selfieImageView?.drawable as BitmapDrawable))
            intent.putExtra("userFirstName", firstNameEditText?.text.toString())
            intent.putExtra("userSurname", surnameEditText?.text.toString())
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            REQUEST_IMAGE_CAPTURED -> {
                if(resultCode == Activity.RESULT_OK) {
                    val imageBitmap = data?.extras?.get("data") as Bitmap
                    selfieImageView?.setImageBitmap(imageBitmap)
                }
            }
        }
    }

    private fun getBitmapFromAssets(fileName: String): Bitmap? {
        return try {
            BitmapFactory.decodeStream(assets.open(fileName))
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

    private fun drawableToByteArray(drawable: BitmapDrawable): ByteArray {
        val bitmap = drawable.bitmap
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        return stream.toByteArray()
    }
}