package kz.step.stepeducation.activity

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kz.step.stepeducation.R
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream


class RegisteredUserInfoActivity : AppCompatActivity() {
    var selfieImageView: ImageView? = null
    var firstNameEditText: EditText? = null
    var surnameEditText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registered_user_info)

        initializeViews()
    }

    fun initializeViews() {
        selfieImageView = findViewById(R.id.imageview_activity_registered_user_info_user_selfie)
        firstNameEditText = findViewById(R.id.edittext_activity_registered_user_info_user_first_name)
        surnameEditText = findViewById(R.id.edittext_activity_registered_user_info_user_surname)

        val userSelfieByteArray = intent?.extras?.getByteArray("userSelfie")
        val userFirstName = intent?.extras?.getString("userFirstName")
        val userSurname = intent?.extras?.getString("userSurname")

        if (userSelfieByteArray != null) {
            selfieImageView?.setImageBitmap(byteArrayToBitmap(userSelfieByteArray))
        }
        if(userFirstName != null) {
            firstNameEditText?.setText(userFirstName)
        }
        if(userSurname != null) {
            surnameEditText?.setText(userSurname)
        }
    }

    private fun byteArrayToBitmap(byteArray: ByteArray): Bitmap {
        val `is` = ByteArrayInputStream(byteArray)
        return BitmapFactory.decodeStream(`is`)
    }
}