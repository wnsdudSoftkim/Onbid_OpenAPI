package com.example.onbid.gradle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onbid.Home_ShowDetail
import com.example.onbid.R
import com.example.onbid.RecyclerAdapter
import com.example.onbid.RetrofitClient
import com.example.onbid.data.Camco
import com.example.onbid.data.ViewModel
import kotlinx.android.synthetic.main.activity_gradle6.*
import kotlinx.android.synthetic.main.grid_fragment1.*
import retrofit2.Response

class gradle6 : AppCompatActivity() {
    val viewModel: ViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gradle6)
        initview()
        btn_grid6_backpress.setOnClickListener {
            onBackPressed()
        }
        viewModel.Livegrid6data.observe(this, Observer {
            if (viewModel.grid6data.size != null) {
                val adapter =
                    RecyclerAdapter(
                        viewModel.grid6data,
                        LayoutInflater.from(this),
                        onClick = {
                            //여기서 통신을 바로 하고 통신이 완료될 때 까지 dialog 보여준다 통신이 완료되면 상세페이지로 이동하게끔 , data 를 intent 로 보내준다.
                            //물건정보조회 서비스의 상세조회API
                            startActivity(Intent(this, Home_ShowDetail::class.java))
                        })
                recycler_view_grid6.adapter = adapter
                recycler_view_grid6.layoutManager = LinearLayoutManager(this)
                recycler_view_grid6.adapter?.notifyDataSetChanged()
                (recycler_view_grid6.adapter as RecyclerAdapter).setData(it)
            }
        })
    }
    fun initview() {
        if (viewModel.grid6data.size==0) {
            animation_view_gradle6.visibility= View.VISIBLE
            RetrofitClient.dataservice.getMoneygrid6()
                .enqueue(object : retrofit2.Callback<Camco> {
                    override fun onFailure(call: retrofit2.Call<Camco>, t: Throwable) {
                        Toast.makeText(applicationContext,"실패"+t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(
                        call: retrofit2.Call<Camco>,
                        response: Response<Camco>
                    ) {
                        val body = response.body()
                        //viewModel로 데이터를 보내줌.
                        if (body != null) {
                            viewModel.myGrid6SetData(body)
                            animation_view_gradle6.visibility=View.GONE

                        }
                    }

                })
        }

    }
}