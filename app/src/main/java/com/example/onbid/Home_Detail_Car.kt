package com.example.onbid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.onbid.data.CamcoDetailData
import com.example.onbid.data.ViewModel
import kotlinx.android.synthetic.main.activity_home__detail__car.*
import retrofit2.Response

class Home_Detail_Car : AppCompatActivity() {
    val viewModel: ViewModel by viewModels()
var CLTR_NO: String ?= ""
var PBCT_NO: String ?= ""
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home__detail__car)
    btn_cardetail_backpress.setOnClickListener {
        onBackPressed()
    }
    CLTR_NO = intent.getStringExtra("CLTR_NO")
    PBCT_NO = intent.getStringExtra("PBCT_NO")
    if (CLTR_NO != null && PBCT_NO != null) {
        initView()
    }
    viewModel.LiveHomedetaildata.observe(this, Observer {
        if (viewModel.homedetaildata != null) {
            val a = viewModel.homedetaildata[0]
            car_CLTR_NM.setText(""+a.CLTR_NM)
            car_DPSL_MTD_NM.setText(""+a.DPSL_MTD_NM)
            car_PBCT_CLTR_STAT_NM.setText(""+a.PBCT_CLTR_STAT_NM)
            car_ORG_NM.setText(""+a.ORG_NM)
        }
    })

}

fun initView() {
    if (viewModel.homedetaildata != null) {
        RetrofitClient.dataservice.getThingdetail(CLTR_NO!!, PBCT_NO!!)
            .enqueue(object : retrofit2.Callback<CamcoDetailData> {
                override fun onFailure(call: retrofit2.Call<CamcoDetailData>, t: Throwable) {
                    Toast.makeText(
                        this@Home_Detail_Car,
                        "리스트를 읽어오는데 실패하였습니다"+t.message,
                        Toast.LENGTH_LONG
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