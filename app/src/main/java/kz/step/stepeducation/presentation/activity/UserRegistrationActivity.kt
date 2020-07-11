package kz.step.stepeducation.presentation.activity

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_user_registration.*
import kz.step.stepeducation.R
import kz.step.stepeducation.domain.Student
import kz.step.stepeducation.presentation.base.BaseDialog
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


class UserRegistrationActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {
    private var cameraStubBitmap: Bitmap? = null
    private val REQUEST_IMAGE_CAPTURED = 1

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_registration)

        initializeViews()
        initializeListeners()
    }

    fun initializeViews() {
        cameraStubBitmap = getBitmapFromAssets("camera_stub_image.png")
        if(cameraStubBitmap != null) {
            imageview_activity_user_registration_user_selfie?.setImageBitmap(cameraStubBitmap)
        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun initializeListeners() {
        imageview_activity_user_registration_user_selfie?.setOnClickListener {
            if(checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(cameraIntent, REQUEST_IMAGE_CAPTURED)
            } else {
                requestPermissions(Array<String>(1){ android.Manifest.permission.CAMERA }, 101)
            }
        }

        edittext_activity_user_registration_user_dob?.setOnClickListener {
            val dateDialog = DatePickerDialog(this, this, LocalDate.now().year, LocalDate.now().monthValue - 1, LocalDate.now().dayOfMonth)
            dateDialog.show()
        }

        button_activity_user_registration_fill_info?.setOnClickListener {
            val bitmapDrawable = imageview_activity_user_registration_user_selfie?.drawable as BitmapDrawable
            val bitmap = bitmapDrawable.bitmap

            if(bitmap.sameAs(cameraStubBitmap)) {
                Toast.makeText(this, "Невозможно заполнить данные\nИзображение не заполнено!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(edittext_activity_user_registration_user_first_name?.text.isNullOrEmpty()) {
                Toast.makeText(this, "Невозможно заполнить данные\nИмя не заполнено!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(edittext_activity_user_registration_user_surname?.text.isNullOrEmpty()) {
                Toast.makeText(this, "Невозможно заполнить данные\nФамилия не заполнена!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(edittext_activity_user_registration_user_dob?.text.isNullOrEmpty()) {
                Toast.makeText(this, "Невозможно заполнить данные\nДата рождения не заполнена!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

//            val intent = Intent(this, RegisteredUserInfoActivity::class.java)
            val intent = Intent(this, StudentsActivity::class.java)
            val student = Student(edittext_activity_user_registration_user_first_name?.text.toString() + " " + edittext_activity_user_registration_user_surname?.text.toString(),
                                  "Дата рождения - ${edittext_activity_user_registration_user_dob?.text}",
                                  edittext_activity_user_registration_user_group?.text.toString(),
                                  edittext_activity_user_registration_user_mark?.text.toString().toFloat(),
                                  (imageview_activity_user_registration_user_selfie?.drawable as BitmapDrawable).bitmap)
//            intent.putExtra("userSelfie", drawableToByteArray(imageview_activity_user_registration_user_selfie?.drawable as BitmapDrawable))
//            intent.putExtra("userFirstName", edittext_activity_user_registration_user_first_name?.text.toString())
//            intent.putExtra("userSurname", edittext_activity_user_registration_user_surname?.text.toString())
//            intent.putExtra("userDob", edittext_activity_user_registration_user_dob?.text.toString())
            intent.putExtra("student", student)
            startActivity(intent)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onDateSet(view: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.getDefault())
        val date = LocalDate.of(year, monthOfYear, dayOfMonth)
        edittext_activity_user_registration_user_dob?.setText(date.format(formatter))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            REQUEST_IMAGE_CAPTURED -> {
                if(resultCode == Activity.RESULT_OK) {
                    val imageBitmap = data?.extras?.get("data") as Bitmap
                    imageview_activity_user_registration_user_selfie?.setImageBitmap(imageBitmap)
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