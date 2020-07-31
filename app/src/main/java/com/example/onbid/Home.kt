package com.example.onbid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Response
import javax.security.auth.callback.Callback

class Home : AppCompatActivity() {
    val data = ArrayList<CamcoData>()
    val serviceKey =
        "TqjIDWEFUiSaeznEMiLDt2X05LgJsJWP0Ja9xKpbEIbwBfiGFLQoAXV1kpXjBNLZSQyhHOzF5Vh%2Fm4wZE7XXug%3D%3D"

    override fun onCreate(savedInstanceState: Bundle?) { 
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        btn_start.setOnClickListener {

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
}



