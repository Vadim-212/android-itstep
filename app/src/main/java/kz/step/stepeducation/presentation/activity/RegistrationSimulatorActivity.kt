package kz.step.stepeducation.presentation.activity

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_registration_simulator.*
import kz.step.stepeducation.R

class RegistrationSimulatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_simulator)

        initializeListeners()
    }

    @SuppressLint("ResourceAsColor")
    fun initializeListeners() {
        button_activity_registration_simulator_registration.setOnClickListener {
            if(edittext_activity_registration_simulator_name.text.isEmpty()) {
                textview_activity_registration_simulator_status.setTextColor(R.color.red)
                textview_activity_registration_simulator_status.setText("Error, name is empty!")
                return@setOnClickListener
            }

            for(symbol in edittext_activity_registration_simulator_name.text) {
                if(symbol.isDigit()) {
                    textview_activity_registration_simulator_status.setTextColor(R.color.red)
                    textview_activity_registration_simulator_status.setText("Error, we have digits in our name!")
                    return@setOnClickListener
                }
            }

            if(edittext_activity_registration_simulator_email.text.isEmpty()) {
                textview_activity_registration_simulator_status.setTextColor(R.color.red)
                textview_activity_registration_simulator_status.setText("Error, email is empty!")
                return@setOnClickListener
            }

            if(edittext_activity_registration_simulator_password.text != edittext_activity_registration_simulator_repeat_password.text) {
                textview_activity_registration_simulator_status.setTextColor(R.color.red)
                textview_activity_registration_simulator_status.setText("Error, passwords doesn't match!")
                return@setOnClickListener
            }

            textview_activity_registration_simulator_status.setTextColor(R.color.color_black)
            textview_activity_registration_simulator_status.setText("Everithing looks fine!")
        }
    }
}