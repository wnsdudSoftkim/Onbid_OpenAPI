package com.example.onbid.gradle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onbid.Home_ShowDetail
import com.example.onbid.R
import com.example.onbid.RecyclerAdapter
import com.example.onbid.RetrofitClient
import com.example.onbid.data.Camco
import com.example.onbid.data.InsertAsyncTask
import com.example.onbid.data.RoomData
import com.example.onbid.data.ViewModel
import kotlinx.android.synthetic.main.activity_gradle3.*
import kotlinx.android.synthetic.main.activity_gradle4.*
import retrofit2.Response

class gradle4 : AppCompatActivity() {
    val viewModel: ViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gradle4)
        btn_grid4_backpress.setOnClickListener {
            onBackPressed()
        }
        viewModel.Livegrid4data.observe(this, Observer {
            if (viewModel.grid4data.size == 0) {
                val adapter =
                    RecyclerAdapter(
                        viewModel.grid4data,
                        LayoutInflater.from(this),
                        onClick = {
                            //여기서 통신을 바로 하고 통신이 완료될 때 까지 dialog 보여준다 통신이 완료되면 상세페이지로 이동하게끔 , data 를 intent 로 보내준다.
                            //물건정보조회 서비스의 상세조회API
                            startActivity(Intent(this, Home_ShowDetail::class.java))
                        })
                recycler_view_grid4.adapter = adapter
                recycler_view_grid4.layoutManager = LinearLayoutManager(this)
                recycler_view_grid4.adapter?.notifyDataSetChanged()
                (recycler_view_grid4.adapter as RecyclerAdapter).setData(it)
            }
        })
    }
    fun initview() {
        if (viewModel.grid4data.size==0) {
            RetrofitClient.dataservice.getCargrid4()
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
                            viewModel.myGrid4SetData(body)
                            Toast.makeText(applicationContext,"성공"+body,Toast.LENGTH_LONG).show()


                        }
                    }

                })
        }

    }
}