package com.example.onbid

import android.app.Activity
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
        return inflater.inflate(R.layout.activity_fragment1,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
    fun initView(){
        val fragment4 = fragment4()
        val fragment5 = fragment5()
        val fragment6 = fragment6()
        val adapter = pagerAdapter(activity!!.supportFragmentManager)
        adapter.addItems(fragment4)    // adapter는 지원
        adapter.addItems(fragment5)
        adapter.addItems(fragment6)
        viewPager_best.adapter = adapter
        tabLayout_best.setupWithViewPager(viewPager_best)
        tabLayout_best.getTabAt(0)?.setCustomView(createView("관심 best 20"))
        tabLayout_best.getTabAt(1)?.setCustomView(createView("클릭 best 20"))
        tabLayout_best.getTabAt(2)?.setCustomView(createView("50%체감 best 20"))
    }
    fun createView(tabName:String): View {    // 매개
        val tabView  = LayoutInflater.from(context).inflate(R.layout.best_tabview,null)
        tabView.best_text.text = tabName
        when(tabName) {
            "클릭 best 20" -> {
                tabView.best_img.setImageResource(R.drawable.ic_baseline_near_me_24)
            }
            "50%체감 best 20" -> {
                tabView.best_img.setImageResource(R.drawable.percent)
            }
            else -> {
                return tabView
            }
        }
        return tabView
    }
}