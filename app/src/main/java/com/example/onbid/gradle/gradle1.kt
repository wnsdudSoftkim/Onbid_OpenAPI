package com.example.onbid.gradle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.onbid.R
import com.example.onbid.fragment.grid1_fragment1
import com.example.onbid.fragment.grid1_fragment2
import com.example.onbid.fragment.grid1_fragment3
import com.example.onbid.fragment.grid1_fragment4
import com.example.onbid.pagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_gradle1.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.grid_fragment1.*
import kotlinx.android.synthetic.main.grid_tabitem.*

class gradle1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gradle1)
        initView()
        btn_grid1_backpress.setOnClickListener {
            onBackPressed()
        }
    }

    fun initView() {
        val fragment1 = grid1_fragment1()
        val fragment2 = grid1_fragment2()
        val fragment3 = grid1_fragment3()
        val fragment4 = grid1_fragment4()
        val adapter = pagerAdapter(supportFragmentManager)
        adapter.addItems(fragment1)    // adapter는 지원
        adapter.addItems(fragment2)
        adapter.addItems(fragment3)
        adapter.addItems(fragment4)
        viewPager_grid.adapter = adapter
        tabLayout_grid.setupWithViewPager(viewPager_grid)
        tabLayout_grid.getTabAt(0)?.setCustomView(createView("자동차/운송장비"))
        tabLayout_grid.getTabAt(1)?.setCustomView(createView("물품[기계]"))
        tabLayout_grid.getTabAt(2)?.setCustomView(createView("물품[기타]"))
        tabLayout_grid.getTabAt(3)?.setCustomView(createView("권리/증권"))

        tabLayout_grid.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                when (tab!!.position) {
                    0 -> {
                        linear_grid1_color1.setBackgroundResource(R.color.gray6)
                    }
                    1 -> {
                        linear_grid1_color2.setBackgroundResource(R.color.gray6)
                    }
                    2 -> {
                        linear_grid1_color3.setBackgroundResource(R.color.gray6)
                    }
                    3 -> {
                        linear_grid1_color4.setBackgroundResource(R.color.gray6)
                    }
                    else -> {

                    }
                }
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {

                when (tab!!.position) {
                    0 -> {
                        linear_grid1_color1.setBackgroundResource(R.color.ourcolor)
                    }
                    1 -> {
                        linear_grid1_color2.setBackgroundResource(R.color.ourcolor)
                    }
                    2 -> {
                        linear_grid1_color3.setBackgroundResource(R.color.ourcolor)
                    }
                    3 -> {
                        linear_grid1_color4.setBackgroundResource(R.color.ourcolor)
                    }
                    else -> {

                    }
                }

            }
        })
    }

    fun createView(item: String): View {
        val view = LayoutInflater.from(this).inflate(R.layout.grid_tabitem, null)
        val viewtext = view.findViewById<TextView>(R.id.text_grid1_text)
        val viewlinear = view.findViewById<LinearLayout>(R.id.linear_grid1_tab)
        viewtext.text = item
        return viewlinear
    }
}