package com.example.onbid.gradle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onbid.*
import com.example.onbid.data.Camco
import com.example.onbid.data.ViewModel
import com.example.onbid.fragment.grid1_fragment1
import com.example.onbid.fragment.grid1_fragment2
import com.example.onbid.fragment.grid1_fragment3
import com.example.onbid.fragment.grid1_fragment4
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_gradle1.*
import kotlinx.android.synthetic.main.activity_gradle3.*
import kotlinx.android.synthetic.main.grid_fragment1.*
import kotlinx.android.synthetic.main.grid_tabitem.*
import retrofit2.Response

class gradle3 : AppCompatActivity() {
    val viewModel: ViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gradle3)
        initview()
        btn_grid3_backpress.setOnClickListener {
            onBackPressed()
        }
        viewModel.Livegrid3data.observe(this, Observer {
            if (viewModel.grid3data.size != null) {
                val adapter =
                    RecyclerAdapter(
                        viewModel.grid3data,
                        LayoutInflater.from(this),
                        onClick = {
                            //여기서 통신을 바로 하고 통신이 완료될 때 까지 dialog 보여준다 통신이 완료되면 상세페이지로 이동하게끔 , data 를 intent 로 보내준다.
                            //물건정보조회 서비스의 상세조회API
                            startActivity(Intent(this, Home_ShowDetail::class.java))
                        })
                recycler_view_grid3.adapter = adapter
                recycler_view_grid3.layoutManager = LinearLayoutManager(this)
                recycler_view_grid3.adapter?.notifyDataSetChanged()
                (recycler_view_grid3.adapter as RecyclerAdapter).setData(it)
            }
        })
    }




    fun initview() {
        if (viewModel.grid3data.size==0) {
            animation_view_gradle3.visibility=View.VISIBLE
            RetrofitClient.dataservice.get50()
                .enqueue(object : retrofit2.Callback<Camco> {
                    override fun onFailure(call: retrofit2.Call<Camco>, t: Throwable) {
                        Toast.makeText(applicationContext,"실패"+t.message,Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(
                        call: retrofit2.Call<Camco>,
                        response: Response<Camco>
                    ) {
                        val body = response.body()
                        //viewModel로 데이터를 보내줌.
                        if (body != null) {
                            viewModel.myGrid3SetData(body)
                            animation_view_gradle3.visibility=View.GONE


                        }
                    }

                })
        }

    }

}