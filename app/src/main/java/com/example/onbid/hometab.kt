package com.example.onbid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.activity.viewModels

import com.example.onbid.data.ViewModel
import com.example.onbid.fragment.*

import kotlinx.android.synthetic.main.activity_hometab.*

class hometab : AppCompatActivity() {
    val viewModel: ViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hometab)
        initView()


    }

    fun initView() {
        val fragment1 = fragment1()
        val fragment2 = fragment2()
        val fragment3 = fragment3()
        val fragment4 = fragment4()
        val fragment5 = fragment5()
        val adapter = pagerAdapter(supportFragmentManager)
        adapter.addItems(fragment1)    // adapter는 지원
        adapter.addItems(fragment2)
        adapter.addItems(fragment3)
        adapter.addItems(fragment4)
        adapter.addItems(fragment5)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_baseline_menu_24)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_baseline_search_24)
        tabLayout.getTabAt(2)?.setIcon(R.drawable.ic_baseline_home_24)
        tabLayout.getTabAt(3)?.setIcon(R.drawable.ic_baseline_favorite_24)
        tabLayout.getTabAt(4)?.setIcon(R.drawable.ic_baseline_person_24)


    }


}