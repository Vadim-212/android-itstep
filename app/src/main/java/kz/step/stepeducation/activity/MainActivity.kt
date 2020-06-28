package kz.step.stepeducation.activity

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kz.step.stepeducation.*


class MainActivity : AppCompatActivity() {
    var buttonAction: Button? = null
    var textviewStatus: TextView? = null
    var gotoStudentsActivityButton: Button? = null
    var openCameraButton: Button? = null
    var startCallButton: Button? = null
    var gotoActivity1Button: Button? = null
    var gotoActivityPhotoButton: Button? = null
    var gotoActivityTestButton: Button? = null
    var gotoActivityLoginButton: Button? = null
    var gotoShoppingListActivityButton: Button? = null
    var gotoApiVersionActivity: Button? = null
    var gotoWhatsappActivity: Button? = null
    var gotoNewLoginActivity: Button? = null
    var callAppCrashButton: Button? = null
    var gotoSpeechRecognizerActivity: Button? = null

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
        initializeListeners()
    }

    fun initializeViews() {
        textviewStatus = findViewById(R.id.textview_activity_main_status)
        buttonAction = findViewById(R.id.button_activity_main_action)
        gotoStudentsActivityButton = findViewById(R.id.button_activity_main_goto_students_activity)
        openCameraButton = findViewById(R.id.button_activity_main_open_camera)
        startCallButton = findViewById(R.id.button_activity_main_start_call)
        gotoActivity1Button = findViewById(R.id.button_activity_main_goto_activity1)
        gotoActivityPhotoButton = findViewById(R.id.button_activity_main_goto_activity_photo)
        gotoActivityTestButton = findViewById(R.id.button_activity_main_goto_activity_test)
        gotoActivityLoginButton = findViewById(R.id.button_activity_main_goto_activity_login)
        gotoShoppingListActivityButton = findViewById(R.id.button_activity_main_goto_activity_shopping_list)
        gotoApiVersionActivity = findViewById(R.id.button_activity_main_goto_activity_api_version)
        gotoWhatsappActivity = findViewById(R.id.button_activity_main_goto_activity_whatsapp)
        gotoNewLoginActivity = findViewById(R.id.button_activity_main_goto_activity_new_login)
        callAppCrashButton = findViewById(R.id.button_activity_main_call_crash)
        gotoSpeechRecognizerActivity = findViewById(R.id.button_activity_main_goto_activity_speech_recognizer)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun initializeListeners() {
        buttonAction?.setOnClickListener {
            textviewStatus?.setTextColor(ContextCompat.getColor(this,
                R.color.red
            ))
        }

        gotoStudentsActivityButton?.setOnClickListener {
            val intent = Intent(applicationContext, StudentsActivity::class.java)
            startActivity(intent)
        }

        openCameraButton?.setOnClickListener {
            if(checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(cameraIntent, 1)
            } else {
                requestPermissions(Array<String>(1){android.Manifest.permission.CAMERA}, 101)
            }
        }

        startCallButton?.setOnClickListener {
            if(checkSelfPermission(android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "1234567890"))
                startActivity(intent)
            } else {
                requestPermissions(Array<String>(1){android.Manifest.permission.CALL_PHONE}, 101)
            }
        }

        gotoActivity1Button?.setOnClickListener {
            val intent = Intent(this, DataActivity1::class.java)
            startActivity(intent)
        }

        gotoActivityPhotoButton?.setOnClickListener {
            val intent = Intent(this, PhotoActivity::class.java)
            startActivity(intent)
        }

        gotoActivityTestButton?.setOnClickListener {
            val intent = Intent(this, TestActivity::class.java)
            startActivity(intent)
        }

        gotoActivityLoginButton?.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        gotoShoppingListActivityButton?.setOnClickListener {
            val intent = Intent(this, ShoppingListActivity::class.java)
            startActivity(intent)
        }

        gotoApiVersionActivity?.setOnClickListener {
            val intent = Intent(this, APIVersionActivity::class.java)
            startActivity(intent)
        }

        gotoWhatsappActivity?.setOnClickListener {
            val intent = Intent(this, WhatsappActivity::class.java)
            startActivity(intent)
        }

        gotoNewLoginActivity?.setOnClickListener {
            val intent = Intent(this, NewLoginActivity::class.java)
            startActivity(intent)
        }

        callAppCrashButton?.setOnClickListener {
            val intent = Intent(this, StudentsSortUseCase::class.java) // Вызов класса, который не является activity
            startActivity(intent)
        }

        gotoSpeechRecognizerActivity?.setOnClickListener {
            val intent = Intent(this, SpeechRecognizerActivity::class.java) // Вызов класса, который не является activity
            startActivity(intent)
        }
    }
}