package com.example.onbid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_appraisal_report.*

class Appraisal_report : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appraisal_report)
        btn_appraisal_backpress.setOnClickListener {
            onBackPressed()
        }
    }
}