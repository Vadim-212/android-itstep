package kz.step.stepeducation.presentation.activity

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_speech_recognizer.*
import kz.step.stepeducation.R
import kz.step.stepeducation.domain.usecase.SpeechRecognizerHelper
import java.util.*

class SpeechRecognizerActivity : AppCompatActivity() {
    private val REQUEST_CODE_SPEECH_RECOGNIZER = 1
    val speechRecognizerHelper = SpeechRecognizerHelper(this, REQUEST_CODE_SPEECH_RECOGNIZER)

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_speech_recognizer)

        initializeListeners()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun initializeListeners() {
        button_activity_speech_recognizer_recognize?.setOnClickListener {
            speechRecognizerHelper.startSpeechRecognize()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            REQUEST_CODE_SPEECH_RECOGNIZER -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    val result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                    if (!result.isNullOrEmpty()) {
                        val recognizedText = result[0]
                        textview_activity_speech_recognizer_recognized_text?.setText(recognizedText)
                    }
                }
            }
        }
    }
}