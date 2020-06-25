package kz.step.stepeducation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kz.step.stepeducation.R

class LoginActivity : AppCompatActivity() {
    private val LOGIN = "icarus"
    private val PASSWORD = "fallen"
    var loginEditText: EditText? = null
    var passwordEditText: EditText? = null
    var loginButton: Button? = null
    var textTextView: TextView? = null
    var hideViewsButton: Button? = null
    var isViewsHided: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initializeViews()
        initializeListeners()
    }

    fun initializeViews() {
        loginEditText = findViewById(R.id.edittext_activity_login_login)
        passwordEditText = findViewById(R.id.edittext_activity_login_password)
        loginButton = findViewById(R.id.button_activity_login_login)
        textTextView = findViewById(R.id.textview_activity_login_text)
        hideViewsButton = findViewById(R.id.button_activity_login_hide_views)
    }

    fun initializeListeners() {
        loginButton?.setOnClickListener {
            if (loginEditText?.text.toString() == LOGIN && passwordEditText?.text.toString() == PASSWORD)
                textTextView?.text = "It is so sad =("
            else
                textTextView?.text = ""
        }

        hideViewsButton?.setOnClickListener {
            if(isViewsHided) {
                loginEditText?.visibility = View.VISIBLE
                passwordEditText?.visibility = View.VISIBLE
                textTextView?.visibility = View.VISIBLE
                loginButton?.visibility = View.VISIBLE
            } else {
                loginEditText?.visibility = View.INVISIBLE
                passwordEditText?.visibility = View.INVISIBLE
                textTextView?.visibility = View.INVISIBLE
                loginButton?.visibility = View.INVISIBLE
            }
            isViewsHided = !isViewsHided
        }
    }
}