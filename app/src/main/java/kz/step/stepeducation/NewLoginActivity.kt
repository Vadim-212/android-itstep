package kz.step.stepeducation

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class NewLoginActivity : AppCompatActivity() {
    var loginEditText: EditText? = null
    var passwordEditText: EditText? = null
    var enterButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_login)
        initializeViews()
        initializeListeners()
    }

    fun initializeViews() {
        loginEditText = findViewById(R.id.edittext_activity_new_login_login)
        passwordEditText = findViewById(R.id.edittext_activity_new_login_password)
        enterButton = findViewById(R.id.button_activity_new_login_enter)
    }

    fun initializeListeners() {
        enterButton?.setOnClickListener {
            val login = loginEditText?.text.toString()
            val password = passwordEditText?.text.toString()

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