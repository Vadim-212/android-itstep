package kz.step.stepeducation.activity

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kz.step.stepeducation.R

class APIVersionActivity : AppCompatActivity() {
    val deviceApiVersion = Build.VERSION.SDK_INT
    val deviceVersionRelease = Build.VERSION.RELEASE
    val deviceVersionName = Build.VERSION_CODES::class.java.declaredFields
    var apiTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api_version)
        initializeViews()

        val apiString = "API v$deviceApiVersion\nAndroid $deviceVersionRelease ${deviceVersionName.get(deviceApiVersion).name}"
        apiTextView?.text = apiString
    }

    fun initializeViews() {
        apiTextView = findViewById(R.id.textview_activity_api_version_text)
    }
}