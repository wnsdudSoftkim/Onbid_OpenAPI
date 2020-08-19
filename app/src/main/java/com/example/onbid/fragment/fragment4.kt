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
import com.example.onbid.data.CamcoNotice
import com.example.onbid.data.ViewModel
import kotlinx.android.synthetic.main.activitu_fragment4.*
import kotlinx.android.synthetic.main.activity_fragment3.*
import retrofit2.Response

class fragment4: Fragment() {
    val viewModel: ViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initview()
        return inflater.inflate(R.layout.activitu_fragment4,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.Livenoticedata.observe(viewLifecycleOwner, Observer {
            if (viewModel.noticedata != null) {
                val adapter =
                    RecyclerAdapter2(
                        viewModel.noticedata,
                        LayoutInflater.from(context)
                       )
                recycler_view2.adapter = adapter
                recycler_view2.layoutManager = LinearLayoutManager(context)
                recycler_view2.adapter?.notifyDataSetChanged()
                (recycler_view2.adapter as RecyclerAdapter2).setData(it)
            }
        })

    }

    fun initview() {
        if(viewModel.noticedata!=null) {

            RetrofitClient.dataservice.getcalender()
                .enqueue(object : retrofit2.Callback<CamcoNotice> {
                    override fun onFailure(call: retrofit2.Call<CamcoNotice>, t: Throwable) {
                        Toast.makeText(context, "리스트를 읽어오는데 실패하였습니다", Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(
                        call: retrofit2.Call<CamcoNotice>,
                        response: Response<CamcoNotice>
                    ) {
                        val body = response.body()
                        //viewModel로 데이터를 보내줌.
                        if (body != null) {
                            //viewModel.mysHomeListSetData(body)
                            viewModel.myNoticeData(body)
                            //val a = body.body[0].items[0].item as ArrayList<RoomData>
                            //val task = InsertAsyncTask(a, context)
                            //task.execute()

                        }
                    }

                })

        }
    }
}