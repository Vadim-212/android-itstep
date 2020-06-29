package kz.step.stepeducation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_data1.*
import kz.step.stepeducation.R

class DataActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data1)
        initializeListeners()
    }

    fun initializeListeners() {
        button_activity_data1_goto_activity!!.setOnClickListener {
            val intent = Intent(this, DataActivity2::class.java)
            intent.putExtra("dataParameter1", "this is a parameter from activity 1")
            startActivity(intent, Bundle())
        }
    }
}