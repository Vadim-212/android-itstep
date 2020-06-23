package kz.step.stepeducation

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class WhatsappActivity : AppCompatActivity() {
    var sendMessageButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_whatsapp)
        initializeViews()
        initializeListeners()
    }

    fun initializeViews() {
        sendMessageButton = findViewById(R.id.button_activity_whatsapp_send_message)
    }

    fun initializeListeners() {
        sendMessageButton?.setOnClickListener {
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