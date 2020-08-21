package com.example.onbid.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.onbid.R
import com.example.onbid.gradle.gradle1
import com.example.onbid.gradle.gradle2
import com.example.onbid.gradle.gradle3
import com.example.onbid.menu.canContract
import com.example.onbid.menu.emargyTop
import com.example.onbid.menu.newList
import kotlinx.android.synthetic.main.activity_fragment1.*

class fragment1 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_fragment1,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment1_2.setOnClickListener {
            startActivity(Intent(context,emargyTop::class.java))
        }
        fragment1_3.setOnClickListener {
            startActivity(Intent(context,canContract::class.java))
        }
        fragment1_4.setOnClickListener {
            startActivity(Intent(context,gradle3::class.java))
        }
        fragment1_5.setOnClickListener {
            startActivity(Intent(context,gradle2::class.java))
        }
        fragment1_6.setOnClickListener {
            startActivity(Intent(context,gradle1::class.java))
        }
    }
}