package com.example.onbid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_fragment1.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (rotate.getAnimation() == null) {
            val rotateAnimation : Animation = AnimationUtils.loadAnimation (getApplicationContext(), R.anim.anim_image)
            rotate.startAnimation(rotateAnimation)
            rotate.setAnimation(rotateAnimation)
        }

        Handler().postDelayed({
            startActivity(Intent(this, hometab::class.java))

        },4500)
    }
}