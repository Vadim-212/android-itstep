package kz.step.stepeducation.domain.usecase

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Build
import android.speech.RecognizerIntent
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.util.*

class SpeechRecognizerHelper(var contextActivity: Activity, var requestCode: Int): ISpeechRecognizerHelper {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun startSpeechRecognize() {
        val recognizeIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        recognizeIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        recognizeIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        try {
            contextActivity.startActivityForResult(recognizeIntent, requestCode)
        } catch(e: ActivityNotFoundException) {
            e.printStackTrace()
            Toast.makeText(contextActivity, "Ваше устройство не поддерживает разпознавание речи.", Toast.LENGTH_SHORT).show()
        }

    }
}