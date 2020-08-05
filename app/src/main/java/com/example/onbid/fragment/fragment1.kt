package com.example.onbid.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onbid.*
import com.example.onbid.data.Camco
import com.example.onbid.data.ViewModel
import kotlinx.android.synthetic.main.activity_fragment1.*
import retrofit2.Response


class fragment1 : Fragment() {
    val viewModel: ViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initview()
        return inflater.inflate(R.layout.activity_fragment1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //홈 전체목록 통신을 위한 함수

        gradle1.setOnClickListener {
            startActivity(
                Intent(
                    context,
                    com.example.onbid.gradle.gradle1::class.java
                )
            )


        }
        gradle2.setOnClickListener {
            startActivity(
                Intent(
                    context,
                    com.example.onbid.gradle.gradle2::class.java
                )
            )
        }
        gradle3.setOnClickListener {
            startActivity(
                Intent(
                    context,
                    com.example.onbid.gradle.gradle3::class.java
                )
            )
        }
        gradle4.setOnClickListener {
            startActivity(
                Intent(
                    context,
                    com.example.onbid.gradle.gradle4::class.java
                )
            )
        }
        gradle5.setOnClickListener {
            startActivity(
                Intent(
                    context,
                    com.example.onbid.gradle.gradle5::class.java
                )
            )
        }
        gradle6.setOnClickListener {
            startActivity(
                Intent(
                    context,
                    com.example.onbid.gradle.gradle6::class.java
                )
            )
        }


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.Livedata.observe(viewLifecycleOwner, Observer {
            if (viewModel.data != null) {
                val adapter =
                    RecyclerAdapter(
                        viewModel.data,
                        LayoutInflater.from(context),
                        onClick = {
                            startActivity(Intent(context,Home_ShowDetail::class.java))
                        })
                recycler_view.adapter = adapter
                recycler_view.layoutManager = LinearLayoutManager(context)
                recycler_view.adapter?.notifyDataSetChanged()
                (recycler_view.adapter as RecyclerAdapter).setData(it)
            }
        })
    }

    //통신 후 viewModel 에서 데이터를 꺼내와줌.
    fun initview() {
        RetrofitClient.dataservice.getdata()
            .enqueue(object : retrofit2.Callback<Camco> {
                override fun onFailure(call: retrofit2.Call<Camco>, t: Throwable) {
                    Toast.makeText(context,"리스트를 읽어오는데 실패하였습니다",Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: retrofit2.Call<Camco>,
                    response: Response<Camco>
                ) {
                    val body = response.body()
                    //viewModel로 데이터를 보내줌.
                    if (body != null) {
                        viewModel.mysHomeListSetData(body)
                    }
                }

            })

    }


}





