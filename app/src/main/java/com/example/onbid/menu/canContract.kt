package com.example.onbid.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater

import android.view.View

import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onbid.*
import com.example.onbid.data.Camco
import com.example.onbid.data.ViewModel
import kotlinx.android.synthetic.main.activity_can_contract.*
import kotlinx.android.synthetic.main.activity_emargy_top.*
import kotlinx.android.synthetic.main.grid_fragment1.*
import retrofit2.Response

class canContract : AppCompatActivity() {
    val viewModel: ViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_can_contract)
        btn_cancontract_backpress.setOnClickListener {
            onBackPressed()
        }
        initview()
        viewModel.Livecancontractdata.observe(this, Observer {
            if (viewModel.cancontractdata.size != 0) {
                val adapter =
                    RecyclerAdapter(
                        viewModel.cancontractdata,
                        LayoutInflater.from(this),
                        onClick = {
                            //여기서 통신을 바로 하고 통신이 완료될 때 까지 dialog 보여준다 통신이 완료되면 상세페이지로 이동하게끔 , data 를 intent 로 보내준다.
                            //물건정보조회 서비스의 상세조회API
                            startActivity(Intent(this, Home_Detail_Car::class.java))
                        })
                recycler_view_emergency.adapter = adapter
                recycler_view_emergency.layoutManager = LinearLayoutManager(this)
                recycler_view_emergency.adapter?.notifyDataSetChanged()
                (recycler_view_emergency.adapter as RecyclerAdapter).setData(it)
            }
        })
    }



    fun initview() {
        if (viewModel.cancontractdata.size==0) {
            animation_view_cancontract.visibility= View.VISIBLE
            RetrofitClient.dataservice.getcontract()
                .enqueue(object : retrofit2.Callback<Camco> {
                    override fun onFailure(call: retrofit2.Call<Camco>, t: Throwable) {
                        Toast.makeText(this@canContract,""+t.message,Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(
                        call: retrofit2.Call<Camco>,
                        response: Response<Camco>
                    ) {
                        val body = response.body()
                        //viewModel로 데이터를 보내줌.
                        if (body != null) {
                            viewModel.mycancontractSetData(body)
                            animation_view_cancontract.visibility=View.GONE
                        }
                    }

                })
        }

    }
}