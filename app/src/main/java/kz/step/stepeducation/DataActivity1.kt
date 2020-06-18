package kz.step.stepeducation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DataActivity1 : AppCompatActivity() {
    var gotoActivity2Button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data1)
        initializeViews()
        initializeListeners()
    }

    fun initializeViews() {
        gotoActivity2Button = findViewById(R.id.button_activity_data1_goto_activity)
    }

    fun initializeListeners() {
        gotoActivity2Button!!.setOnClickListener {
            val intent = Intent(this, DataActivity2::class.java)
            intent.putExtra("dataParameter1", "this is a parameter from activity 1")
            startActivity(intent, Bundle())
        }
    }
}