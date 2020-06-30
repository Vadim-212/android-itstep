package kz.step.stepeducation.presentation.activity

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_new_login.*
import kz.step.stepeducation.R

class NewLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_login)
        initializeListeners()
    }

    fun initializeListeners() {
        button_activity_new_login_enter?.setOnClickListener {
            val login = edittext_activity_new_login_login?.text.toString()
            val password = edittext_activity_new_login_password?.text.toString()

            if(login == "" || password == "") {
                Toast.makeText(this, "Login and password must be filled", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, "Login - $login\nPassword - $password")
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