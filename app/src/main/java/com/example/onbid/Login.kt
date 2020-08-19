package com.example.onbid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.onbid.data.LoginData
import com.example.onbid.data.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import retrofit2.Call
import retrofit2.Response

class Login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
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
            if (edit_login_email.text.toString().length <= 0 && edit_login_password.text.toString().length <= 0) {
                Toast.makeText(this, "이메일과 비밀번호를 기입해주세요", Toast.LENGTH_LONG).show()
            }else {
                getLogin()

            }
        }
    }
    private fun getLogin() {
        val loginEmail = edit_login_email.text.toString()
        val loginPassword = edit_login_password.text.toString()
        auth.signInWithEmailAndPassword(loginEmail ,loginPassword)
            .addOnCompleteListener(this) { task ->
                Toast.makeText(this,"로그인에러:"+task.exception,Toast.LENGTH_LONG).show()
                if (task.isSuccessful==true) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(this,"성공",Toast.LENGTH_LONG).show()
                    val user = auth.currentUser
                    updateUI(user)

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this,"아이디와 비밀번호 양식을 정확히 기입해주세요",Toast.LENGTH_SHORT)
                    // ...
                }

                // ...
            }
    }
    fun updateUI(account: FirebaseUser?) {
        if (account != null) {
            Toast.makeText(this, "홈 화면으로 이동합니다.", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, hometab::class.java))
        } else {

        }
    }
}