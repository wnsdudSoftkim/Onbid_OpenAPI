package com.example.onbid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.example.onbid.data.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_sign_up.*
import retrofit2.Call
import retrofit2.Response

class SignUp : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    val viewModel: ViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        //뒤로가기 버튼
        auth=FirebaseAuth.getInstance()
        signup_backpress.setOnClickListener {
            onBackPressed()
        }
        btn_signup.setOnClickListener {
            if (edit_signup_email.text.toString().length <= 0 && edit_signup_password.text.toString().length <= 0) {
                Toast.makeText(this, "이메일과 비밀번호를 기입해주세요", Toast.LENGTH_LONG).show()
            }else {
                signup()
            }
        }

    }
    fun signup() {
        val email = edit_signup_email.text.toString()
        val password = edit_signup_password.text.toString()
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    updateUI(user)

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("Sign", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "이메일과 비밀번호 양식을 정확히 기입해주세요.",
                        Toast.LENGTH_SHORT
                    ).show()

                }

            }
    }
    fun updateUI(account: FirebaseUser?) {
        if (account != null) {
            Toast.makeText(this, "홈 화면으로 이동합니다.", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, hometab::class.java))
        } else {
            Toast.makeText(this, "?????", Toast.LENGTH_SHORT).show()
        }
    }








}