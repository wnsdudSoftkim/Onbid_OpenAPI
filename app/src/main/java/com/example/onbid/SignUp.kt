package com.example.onbid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.example.onbid.data.LoginData
import com.example.onbid.data.ViewModel
import kotlinx.android.synthetic.main.activity_sign_up.*
import retrofit2.Call
import retrofit2.Response

class SignUp : AppCompatActivity() {
    val viewModel: ViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        //뒤로가기 버튼
        signup_backpress.setOnClickListener {
            onBackPressed()
        }
        btn_signup.setOnClickListener {
            signup()
        }
    }
    //회원가입
    //이메일 중복체크 작업 해야함.
    fun signup() {
        if (edit_signup_email.toString() != null && edit_signup_password.toString() != null && edit_signup_name.toString() != null) {
            RetrofitClient.loginservice.SignUp(
                edit_signup_email.toString(),
                edit_signup_password.toString(),
                edit_signup_name.toString()
            ).enqueue(object : retrofit2.Callback<LoginData>{
                override fun onFailure(call: Call<LoginData>, t: Throwable) {
                    Toast.makeText(applicationContext,"에러",Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<LoginData>, response: Response<LoginData>) {
                    viewModel.setLoginData(response.body()!!)
                    Toast.makeText(applicationContext,"회원가입 성공하였습니다",Toast.LENGTH_SHORT).show()
                    startActivity(Intent(applicationContext,hometab::class.java))
                }
            })

        } else {
            Toast.makeText(this, "정확히 기입해주세요", Toast.LENGTH_SHORT).show()
        }
    }

}