package kz.step.stepeducation.presentation.activity

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_whatsapp.*
import kz.step.stepeducation.R
import kz.step.stepeducation.domain.usecase.SocialNetworkHelper

class WhatsappActivity : AppCompatActivity() {
    val socialNetworkHelper = SocialNetworkHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_whatsapp)
        initializeListeners()
    }

    fun initializeListeners() {
        button_activity_whatsapp_send_message?.setOnClickListener {
            socialNetworkHelper.sendText("com.whatsapp", "Hello i have written Intent which sending you this message")
        }
    }
}