package com.example.onbid.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.onbid.R
import kotlinx.android.synthetic.main.activity_fragment2.*

class fragment2 : Fragment() {
    var result1 :String?=null
    var result2 : String?=null
    var result3 : String?=null
    var result4 : String?=null
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
            startActivityForResult(Intent(context,
                fragment2_searchpopup::class.java),200)
        }
        btn_search.setOnClickListener {
            if(edit_search.toString()!=null) {


            }else {
                Toast.makeText(context,"기입해주세요",Toast.LENGTH_SHORT).show()
            }
        }

    }
    //돌아오는 값 받기
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==200) {
            if(resultCode==Activity.RESULT_OK) {
                result1 = data?.getStringExtra("check1")
                result2 = data?.getStringExtra("check2")
                result3 = data?.getStringExtra("selectedValue")
                result4 = data?.getStringExtra("selectedValue2")
                text_search_result1.setText(result1)
                text_search_result2.setText(result2)
                text_search_select1.setText(result3)
                text_search_select2.setText(result4)
            }
        }
    }
}


