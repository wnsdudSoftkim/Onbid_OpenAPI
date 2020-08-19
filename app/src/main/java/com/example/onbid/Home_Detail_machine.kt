package com.example.onbid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.onbid.data.ViewModel
import kotlinx.android.synthetic.main.activity_home__detail__car.*
import kotlinx.android.synthetic.main.activity_home__detail_machine.*

class Home_Detail_machine : AppCompatActivity() {
    val viewModel: ViewModel by viewModels()
    var CLTR_NO: String? = ""
    var PBCT_NO: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home__detail_machine)
        CLTR_NO = intent.getStringExtra("CLTR_NO")
        PBCT_NO = intent.getStringExtra("PBCT_NO")
        if (CLTR_NO != null && PBCT_NO != null) {
            initView()
        }
        btn_machine_backpress.setOnClickListener {
            onBackPressed()
        }
        btn_machine_popup.setOnClickListener {
            val intent = Intent(this,Appraisal_report::class.java)
            intent.putExtra("CLTR_NO",CLTR_NO)
            intent.putExtra("PBCT_NO",PBCT_NO)
            startActivity(intent)
        }
    }
    fun initView() {

    }
}