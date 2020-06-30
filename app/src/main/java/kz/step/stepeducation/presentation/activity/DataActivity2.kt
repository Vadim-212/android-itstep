package kz.step.stepeducation.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_data2.*
import kz.step.stepeducation.R

class DataActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data2)
        textview_activity_data2_data?.text = intent.getStringExtra("dataParameter1")
    }
}