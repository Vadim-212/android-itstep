package kz.step.stepeducation.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*
import kz.step.stepeducation.R

class LoginActivity : AppCompatActivity() {
    private val LOGIN = "icarus"
    private val PASSWORD = "fallen"
    var isViewsHided: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initializeListeners()
    }

    fun initializeListeners() {
        button_activity_login_login?.setOnClickListener {
            if (edittext_activity_login_login?.text.toString() == LOGIN && edittext_activity_login_password?.text.toString() == PASSWORD)
                textview_activity_login_text?.text = "It is so sad =("
            else
                textview_activity_login_text?.text = ""
        }

        button_activity_login_hide_views?.setOnClickListener {
            if(isViewsHided) {
                edittext_activity_login_login?.visibility = View.VISIBLE
                edittext_activity_login_password?.visibility = View.VISIBLE
                textview_activity_login_text?.visibility = View.VISIBLE
                button_activity_login_login?.visibility = View.VISIBLE
            } else {
                edittext_activity_login_login?.visibility = View.INVISIBLE
                edittext_activity_login_password?.visibility = View.INVISIBLE
                textview_activity_login_text?.visibility = View.INVISIBLE
                button_activity_login_login?.visibility = View.INVISIBLE
            }
            isViewsHided = !isViewsHided
        }
    }
}