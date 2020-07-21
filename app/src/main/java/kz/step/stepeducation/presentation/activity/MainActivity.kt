package kz.step.stepeducation.presentation.activity

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.room.ColumnInfo
import androidx.room.Room
import kz.step.stepeducation.*
import kotlinx.android.synthetic.main.activity_main.*
import kz.step.stepeducation.data.Movie
import kz.step.stepeducation.data.StepEducationDatabase
import kz.step.stepeducation.domain.HelperClass
import kz.step.stepeducation.domain.StudentsSortUseCase
import java.util.*


class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeListeners()
//
//        Room.databaseBuilder(
//            this,
//            StepEducationDatabase::class.java,
//            "StepEducationDatabase").allowMainThreadQueries()
//            .fallbackToDestructiveMigration() // TODO: потеря данных в базе данных, при использовании fallbackToDestructiveMigration()
//            .build().getMovieDao().initiateInsertMovies(listOf(Movie().apply {
//                title = "Movie 1"
//                description = "This is the first movie"
//                rate = 7.8F
//        }, Movie().apply {
//                title = "Movie 2"
//                description = "This is the second movie"
//                rate = 6.2F
//            }, Movie().apply {
//                title = "Movie 3"
//                description = "This is the third movie"
//                rate = 8.2F
//            }))
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun initializeListeners() {
        button_activity_main_action?.setOnClickListener {
            textview_activity_main_status?.setTextColor(ContextCompat.getColor(this,
                R.color.red
            ))
        }

        button_activity_main_goto_students_activity?.setOnClickListener {
            val intent = Intent(applicationContext, StudentsActivity::class.java)
            startActivity(intent)
        }

        button_activity_main_open_camera?.setOnClickListener {
            if(checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(cameraIntent, 1)
            } else {
                requestPermissions(Array<String>(1){android.Manifest.permission.CAMERA}, 101)
            }
        }

        button_activity_main_start_call?.setOnClickListener {
            if(checkSelfPermission(android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "1234567890"))
                startActivity(intent)
            } else {
                requestPermissions(Array<String>(1){android.Manifest.permission.CALL_PHONE}, 101)
            }
        }

        button_activity_main_goto_activity1?.setOnClickListener {
            val intent = Intent(this, DataActivity1::class.java)
            startActivity(intent)
        }

        button_activity_main_goto_activity_photo?.setOnClickListener {
            val intent = Intent(this, PhotoActivity::class.java)
            startActivity(intent)
        }

        button_activity_main_goto_activity_test?.setOnClickListener {
            val intent = Intent(this, TestActivity::class.java)
            startActivity(intent)
        }

        button_activity_main_goto_activity_login?.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        button_activity_main_goto_activity_shopping_list?.setOnClickListener {
            val intent = Intent(this, ShoppingListActivity::class.java)
            startActivity(intent)
        }

        button_activity_main_goto_activity_api_version?.setOnClickListener {
            val intent = Intent(this, APIVersionActivity::class.java)
            startActivity(intent)
        }

        button_activity_main_goto_activity_whatsapp?.setOnClickListener {
            val intent = Intent(this, WhatsappActivity::class.java)
            startActivity(intent)
        }

        button_activity_main_goto_activity_new_login?.setOnClickListener {
            val intent = Intent(this, NewLoginActivity::class.java)
            startActivity(intent)
        }

        button_activity_main_call_crash?.setOnClickListener {
            val intent = Intent(this, StudentsSortUseCase::class.java) // Вызов класса, который не является activity
            startActivity(intent)
        }

        button_activity_main_goto_activity_speech_recognizer?.setOnClickListener {
            val intent = Intent(this, SpeechRecognizerActivity::class.java)
            startActivity(intent)
        }

        button_activity_main_goto_activity_user_registration?.setOnClickListener {
            val intent = Intent(this, UserRegistrationActivity::class.java)
            startActivity(intent)
        }

        button_activity_main_goto_notes_activity?.setOnClickListener {
            val intent = Intent(this, NotesActivity::class.java)
            startActivity(intent)
        }

        button_activity_main_goto_movies_activity?.setOnClickListener {
            val intent = Intent(this, MoviesActivity::class.java)
            startActivity(intent)
        }
    }
}