package kz.step.stepeducation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DataActivity2 : AppCompatActivity() {
    var dataTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data2)
        initializeViews()
        dataTextView?.text = intent.getStringExtra("dataParameter1")
    }

    fun initializeViews() {
        dataTextView = findViewById(R.id.textview_activity_data2_data)
    }
}