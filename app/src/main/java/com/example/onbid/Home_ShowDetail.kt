package com.example.onbid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.onbid.data.CamcoDetailData
import com.example.onbid.data.ViewModel
import retrofit2.Response

class Home_ShowDetail : AppCompatActivity() {
    val viewModel: ViewModel by viewModels()
    var CLTR_NO: String = ""
    var PBCT_NO: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home__show_detail)
        CLTR_NO = intent.getStringExtra("CLTR_NO")
        PBCT_NO = intent.getStringExtra("PBCT_NO")
        if (CLTR_NO != null && PBCT_NO != null) {
            initView()
        }
        viewModel.LiveHomedetaildata.observe(this, Observer {
            if (viewModel.homedetaildata != null) {

            }
        })

    }

    fun initView() {
        if (viewModel.homedetaildata != null) {
            RetrofitClient.dataservice.getThingdetail(CLTR_NO, PBCT_NO)
                .enqueue(object : retrofit2.Callback<CamcoDetailData> {
                    override fun onFailure(call: retrofit2.Call<CamcoDetailData>, t: Throwable) {
                        Toast.makeText(
                            this@Home_ShowDetail,
                            "리스트를 읽어오는데 실패하였습니다",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onResponse(
                        call: retrofit2.Call<CamcoDetailData>,
                        response: Response<CamcoDetailData>
                    ) {
                        val body = response.body()
                        //viewModel로 데이터를 보내줌.
                        if (body != null) {
                            viewModel.myhomedetailData(body)

                        }
                    }

                })

        }

    }
}