package com.example.onbid

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_fragment2.*

class fragment2 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_fragment2,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        text_search_how.setOnClickListener {
            startActivityForResult(Intent(context,fragment2_searchpopup::class.java),200)
        }

    }
    //돌아오는 값 받기
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==200) {
            if(resultCode==Activity.RESULT_OK) {
                val result1 = data?.getStringExtra("check1")
                val result2 = data?.getStringExtra("check2")
                text_search_result1.setText(result1)
                text_search_result2.setText(result2)
            }
        }
    }
}


