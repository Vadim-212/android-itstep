package kz.step.stepeducation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    var buttonAction: Button? = null
    var textviewStatus: TextView? = null
    var gotoStudentsActivityButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
        initializeListeners()
    }

    fun initializeViews() {
        textviewStatus = findViewById(R.id.textview_activity_main_status)
        buttonAction = findViewById(R.id.button_activity_main_action)
        gotoStudentsActivityButton = findViewById(R.id.button_activity_main_goto_students_activity)
    }

    fun initializeListeners() {
        buttonAction?.setOnClickListener(View.OnClickListener {
            textviewStatus?.setTextColor(ContextCompat.getColor(this, R.color.red))
        })

        gotoStudentsActivityButton?.setOnClickListener((View.OnClickListener {
            val intent = Intent(applicationContext, StudentsActivity::class.java)
            // start your next activity
            startActivity(intent)
        }))
    }
}