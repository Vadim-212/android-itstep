package kz.step.stepeducation.activity

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kz.step.stepeducation.R
import kotlinx.android.synthetic.main.activity_api_version.*

class APIVersionActivity : AppCompatActivity() {
    val deviceApiVersion = Build.VERSION.SDK_INT
    val deviceVersionRelease = Build.VERSION.RELEASE
    val deviceVersionName = Build.VERSION_CODES::class.java.declaredFields

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api_version)

        val apiString = "API v$deviceApiVersion\nAndroid $deviceVersionRelease ${deviceVersionName.get(deviceApiVersion).name}"
        textview_activity_api_version_text?.text = apiString
    }
}