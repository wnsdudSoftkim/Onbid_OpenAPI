package com.example.onbid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home__detail__car.*
import kotlinx.android.synthetic.main.activity_home__detail_machine.*

class Home_Detail_machine : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home__detail_machine)
        btn_machine_backpress.setOnClickListener {
            onBackPressed()
        }
        btn_machine_popup.setOnClickListener {
            startActivity(Intent(this,Appraisal_report::class.java))
        }
    }
}