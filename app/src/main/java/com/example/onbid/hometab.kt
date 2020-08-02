package com.example.onbid

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import kotlinx.android.synthetic.main.activity_hometab.*
import kotlinx.android.synthetic.main.tabview.view.*

class hometab : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hometab)
        initView()
    }
    fun initView(){
        val fragment1 = fragment1()
        val fragment2 = fragment2()
        val fragment3 = fragment3()
        val adapter = pagerAdapter(supportFragmentManager)
        adapter.addItems(fragment1)    // adapter는 지원
        adapter.addItems(fragment2)
        adapter.addItems(fragment3)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.getTabAt(0)?.setCustomView(createView("best 20"))
        tabLayout.getTabAt(1)?.setCustomView(createView("물건 조회"))

        tabLayout.getTabAt(2)?.setCustomView(createView("공매 일정"))
    }


    fun createView(tabName:String): View {    // 매개
        val tabView  = LayoutInflater.from(this).inflate(R.layout.tabview,null)
        tabView.hometab_text.text = tabName
        when(tabName) {
            "공매 일정" -> {
                tabView.hometab_img.setImageResource(R.drawable.ic_baseline_calendar_today_24)
            }
            "물건 조회" -> {
                tabView.hometab_img.setImageResource(R.drawable.ic_baseline_search_24)

                tabView.hometab_img.setColorFilter(333)

            }
            else -> {
                return tabView
            }
        }
        return tabView
    }
}