package com.example.onbid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import kotlinx.android.synthetic.main.activity_hometab.*
import kotlinx.android.synthetic.main.tabview.view.*
class pagerAdapter(fragmentmanager : FragmentManager): FragmentStatePagerAdapter(fragmentmanager) {
    private val fragments : ArrayList<Fragment> = ArrayList()
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }
    fun addItems(item: Fragment){
        fragments.add(item)
    }
}