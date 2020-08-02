package com.example.onbid

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_fragment1.*
import kotlinx.android.synthetic.main.activity_hometab.*
import kotlinx.android.synthetic.main.best_tabview.view.*
import kotlinx.android.synthetic.main.tabview.view.*

class fragment1 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_fragment1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gradle1.setOnClickListener {startActivity(Intent(context,com.example.onbid.gradle1::class.java))  }
        gradle2.setOnClickListener {startActivity(Intent(context,com.example.onbid.gradle2::class.java))  }
        gradle3.setOnClickListener {startActivity(Intent(context,com.example.onbid.gradle3::class.java))  }
        gradle4.setOnClickListener {startActivity(Intent(context,com.example.onbid.gradle4::class.java))  }
        gradle5.setOnClickListener {startActivity(Intent(context,com.example.onbid.gradle5::class.java))  }
        gradle6.setOnClickListener {startActivity(Intent(context,com.example.onbid.gradle6::class.java))  }
    }
}
