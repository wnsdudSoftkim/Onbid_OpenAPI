package com.example.onbid.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onbid.Home_ShowDetail
import com.example.onbid.R
import com.example.onbid.RecyclerAdapter
import com.example.onbid.RetrofitClient
import com.example.onbid.data.Camco
import com.example.onbid.data.ViewModel
import kotlinx.android.synthetic.main.grid_fragment1.*
import retrofit2.Response

class grid1_fragment3 : Fragment() {
    val viewModel: ViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initview()

        return inflater.inflate(R.layout.grid_fragment1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.Livegrid1fragment3data.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            if (viewModel.grid1fragment3data != null) {
                val adapter =
                    RecyclerAdapter(
                        viewModel.grid1fragment3data,
                        LayoutInflater.from(context),
                        onClick = {
                            //여기서 통신을 바로 하고 통신이 완료될 때 까지 dialog 보여준다 통신이 완료되면 상세페이지로 이동하게끔 , data 를 intent 로 보내준다.
                            //물건정보조회 서비스의 상세조회API
                            startActivity(Intent(context, Home_ShowDetail::class.java))
                        })
                recycler_view_grid1.adapter = adapter
                recycler_view_grid1.layoutManager = LinearLayoutManager(context)
                recycler_view_grid1.adapter?.notifyDataSetChanged()
                (recycler_view_grid1.adapter as RecyclerAdapter).setData(it)
            }
        })
    }

    fun initview() {
        if (viewModel.grid1fragment3data.size==0) {
            RetrofitClient.dataservice.getTop20("0004","20","1")
                .enqueue(object : retrofit2.Callback<Camco> {
                    override fun onFailure(call: retrofit2.Call<Camco>, t: Throwable) {
                    }

                    override fun onResponse(
                        call: retrofit2.Call<Camco>,
                        response: Response<Camco>
                    ) {
                        val body = response.body()
                        //viewModel로 데이터를 보내줌.
                        if (body != null) {
                            viewModel.myGrid1Fragment3SetData(body)

                        }
                    }

                })
        }

    }
}