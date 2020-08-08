package com.example.onbid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.onbid.data.LoginData
import com.example.onbid.data.ViewModel
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import retrofit2.Call
import retrofit2.Response

class Login : AppCompatActivity() {
    val viewModel: ViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //뒤로가기 버튼
        login_backpress.setOnClickListener {
            onBackPressed()
        }
        text_gosignup.setOnClickListener {
            startActivity(Intent(this,SignUp::class.java))
        }
        btn_login.setOnClickListener {
            login()
        }
    }
    fun login() {
        if (edit_login_email.toString() != null && edit_login_password.toString() != null ) {
            RetrofitClient.loginservice.SignUp(
                edit_signup_email.toString(),
                edit_signup_password.toString(),
                edit_signup_name.toString()
            ).enqueue(object : retrofit2.Callback<LoginData>{
                override fun onFailure(call: Call<LoginData>, t: Throwable) {
                    Toast.makeText(applicationContext,"에러", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<LoginData>, response: Response<LoginData>) {
                    //여기선 로그인 성공시 Hometab 으로 이동해야 한다.
                    viewModel.setLoginData(response.body()!!)

                }
            })

        } else {
            Toast.makeText(this, "정확히 기입해주세요", Toast.LENGTH_SHORT).show()
        }
    }
}