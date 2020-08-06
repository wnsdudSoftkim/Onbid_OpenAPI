package com.example.onbid.fragment

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import com.example.onbid.R
import kotlinx.android.synthetic.main.activity_fragment2_searchpopup.*

class fragment2_searchpopup : AppCompatActivity() {
    private var check1 :String?="전체"
    private var check2 :String?="전체"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment2_searchpopup)
        //뒤로가기
        btn_popupclose.setOnClickListener {
            onBackPressed()
        }
        btn_popupsave.setOnClickListener {
            val intent = Intent()
            intent.putExtra("check1",check1)
            intent.putExtra("check2",check2)
            setResult(Activity.RESULT_OK,intent)
            finish()

        }


    }
    //라디오 체크 시 텍스트 값을 넘겨줌
    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked
            when (view.id) {
                R.id.how_total ->
                    if(checked) {
                        check1=how_total.text.toString()

                    }
                R.id.how_sell ->
                    if(checked) {
                        check1=how_sell.text.toString()
                    }
                R.id.how_borrow ->
                    if(checked) {
                        check1=how_borrow.text.toString()
                    }

                R.id.thing_total ->
                    if(checked){
                        check2 = thing_total.text.toString()
                    }
                R.id.thing_car ->
                    if(checked){
                        check2 = thing_car.text.toString()
                    }

                R.id.thing_thing ->
                    if(checked){
                        check2 = thing_thing.text.toString()
                    }

                R.id.thing_money ->
                    if(checked){
                        check2 = thing_money.text.toString()
                    }


            }
        }
    }

}