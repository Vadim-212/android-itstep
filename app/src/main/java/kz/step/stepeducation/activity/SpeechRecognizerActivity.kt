package kz.step.stepeducation.activity

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kz.step.stepeducation.R
import java.util.*

class SpeechRecognizerActivity : AppCompatActivity() {
    var recognizeButton: Button? = null
    var recognizedTextTextView: TextView? = null
    private val REQUEST_CODE_SPEECH_RECOGNIZER = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_speech_recognizer)

        initializeViews()
        initializeListeners()
    }

    fun initializeViews() {
        recognizeButton = findViewById(R.id.button_activity_speech_recognizer_recognize)
        recognizedTextTextView = findViewById(R.id.textview_activity_speech_recognizer_recognized_text)
    }

    fun initializeListeners() {
        recognizeButton?.setOnClickListener {
            startSpeechRecognize()
        }
    }

    private fun startSpeechRecognize() {
        val recognizeIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        recognizeIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        recognizeIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        try {
            startActivityForResult(recognizeIntent, REQUEST_CODE_SPEECH_RECOGNIZER)
        } catch(e: ActivityNotFoundException) {
            e.printStackTrace()
            Toast.makeText(this, "Ваше устройство не поддерживает разпознавание речи.", Toast.LENGTH_SHORT).show()
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
                        recognizedTextTextView?.setText(recognizedText)
                    }
                }
            }
        }
    }
}