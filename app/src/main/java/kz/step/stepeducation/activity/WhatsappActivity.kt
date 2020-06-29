package kz.step.stepeducation.activity

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_whatsapp.*
import kz.step.stepeducation.R

class WhatsappActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_whatsapp)
        initializeListeners()
    }

    fun initializeListeners() {
        button_activity_whatsapp_send_message?.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, "Hello i have written Intent which sending you this message")
            intent.type = "text/plain"
            intent.`package` = "com.whatsapp"
            try {
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "WhatsApp is not installed...", Toast.LENGTH_SHORT).show()
            }
        }
    }
}