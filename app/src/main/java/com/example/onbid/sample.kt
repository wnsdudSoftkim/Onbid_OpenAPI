package com.example.onbid

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Response

class sample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RetrofitClient.dataservice.getdata()
            .enqueue(object : retrofit2.Callback<Camco> {
                override fun onFailure(call: retrofit2.Call<Camco>, t: Throwable) {
                    text_sample.setText("" + t.message)
                    text_sample2.setText("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ" + t.localizedMessage)
                    Toast.makeText(applicationContext, ""+t.stackTrace, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: retrofit2.Call<Camco>,
                    response: Response<Camco>
                ) {
                    Toast.makeText(applicationContext, "성공했습니다", Toast.LENGTH_SHORT).show()
                    text_sample2.setText(""+response.body())
                }
            })
    }
}