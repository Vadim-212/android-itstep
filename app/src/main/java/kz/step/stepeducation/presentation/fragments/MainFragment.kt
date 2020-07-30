package kz.step.stepeducation.presentation.fragments

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.fragment_main.*
import kz.step.stepeducation.R
import kz.step.stepeducation.domain.StudentsSortUseCase
import kz.step.stepeducation.presentation.activity.*
import kz.step.stepeducation.presentation.base.BaseFragment

class MainFragment : BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeListeners()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.button_activity_main_action -> {
                textview_activity_main_status?.setTextColor(
                    ContextCompat.getColor(context!!,
                        R.color.red
                    ))
            }

            R.id.button_activity_main_goto_students_activity -> {
                val intent = Intent(context!!, StudentsActivity::class.java)
                startActivity(intent)
            }

            R.id.button_activity_main_open_camera -> {
                if(context?.checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(cameraIntent, 1)
                } else {
                    requestPermissions(Array<String>(1){android.Manifest.permission.CAMERA}, 101)
                }
            }

            R.id.button_activity_main_start_call -> {
                if(context?.checkSelfPermission(android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "1234567890"))
                    startActivity(intent)
                } else {
                    requestPermissions(Array<String>(1){android.Manifest.permission.CALL_PHONE}, 101)
                }
            }

            R.id.button_activity_main_goto_activity1 -> {
                val intent = Intent(context!!, DataActivity1::class.java)
                startActivity(intent)
            }

            R.id.button_activity_main_goto_activity_photo -> {
                val intent = Intent(context!!, PhotoActivity::class.java)
                startActivity(intent)
            }

            R.id.button_activity_main_goto_activity_test -> {
                val intent = Intent(context!!, TestActivity::class.java)
                startActivity(intent)
            }

            R.id.button_activity_main_goto_activity_login -> {
                val intent = Intent(context!!, LoginActivity::class.java)
                startActivity(intent)
            }

            R.id.button_activity_main_goto_activity_shopping_list -> {
                val intent = Intent(context!!, ShoppingListActivity::class.java)
                startActivity(intent)
            }

            R.id.button_activity_main_goto_activity_api_version -> {
                val intent = Intent(context!!, APIVersionActivity::class.java)
                startActivity(intent)
            }

            R.id.button_activity_main_goto_activity_whatsapp -> {
                val intent = Intent(context!!, WhatsappActivity::class.java)
                startActivity(intent)
            }

            R.id.button_activity_main_goto_activity_new_login -> {
                val intent = Intent(context!!, NewLoginActivity::class.java)
                startActivity(intent)
            }

            R.id.button_activity_main_call_crash -> {
                val intent = Intent(context!!, StudentsSortUseCase::class.java) // Вызов класса, который не является activity
                startActivity(intent)
            }

            R.id.button_activity_main_goto_activity_speech_recognizer -> {
                val intent = Intent(context!!, SpeechRecognizerActivity::class.java)
                startActivity(intent)
            }

            R.id.button_activity_main_goto_activity_user_registration -> {
                val intent = Intent(context!!, UserRegistrationActivity::class.java)
                startActivity(intent)
            }

            R.id.button_activity_main_goto_notes_activity -> {
                val intent = Intent(context!!, NotesActivity::class.java)
                startActivity(intent)
            }

            R.id.button_activity_main_goto_movies_activity -> {
                val intent = Intent(context!!, MoviesActivity::class.java)
                startActivity(intent)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun initializeListeners() {
        button_activity_main_action?.setOnClickListener(this)

        button_activity_main_goto_students_activity?.setOnClickListener(this)

        button_activity_main_open_camera?.setOnClickListener(this)

        button_activity_main_start_call?.setOnClickListener(this)

        button_activity_main_goto_activity1?.setOnClickListener(this)

        button_activity_main_goto_activity_photo?.setOnClickListener(this)

        button_activity_main_goto_activity_test?.setOnClickListener(this)

        button_activity_main_goto_activity_login?.setOnClickListener(this)

        button_activity_main_goto_activity_shopping_list?.setOnClickListener(this)

        button_activity_main_goto_activity_api_version?.setOnClickListener(this)

        button_activity_main_goto_activity_whatsapp?.setOnClickListener(this)

        button_activity_main_goto_activity_new_login?.setOnClickListener(this)

        button_activity_main_call_crash?.setOnClickListener(this)

        button_activity_main_goto_activity_speech_recognizer?.setOnClickListener(this)

        button_activity_main_goto_activity_user_registration?.setOnClickListener(this)

        button_activity_main_goto_notes_activity?.setOnClickListener(this)

        button_activity_main_goto_movies_activity?.setOnClickListener(this)
    }
}