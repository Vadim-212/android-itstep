package kz.step.stepeducation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var buttonAction: Button? = null
    var textviewStatus: TextView? = null
    var textviewCounter: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
        initializeListeners()
    }

    fun initializeViews() {
        textviewStatus = findViewById(R.id.textview_activity_main_status)
        buttonAction = findViewById(R.id.button_activity_main_action)
        textviewCounter = findViewById(R.id.textview_activity_main_counter)
    }

    fun initializeListeners() {
        buttonAction?.setOnClickListener(View.OnClickListener {
            textviewStatus?.setTextColor(ContextCompat.getColor(this, R.color.red))
        })
    }

    fun button1_onClick(view: View) {
        val counter: Int = textviewCounter?.text.toString().toInt() + 1
        textviewCounter?.text = counter.toString()
    }
}