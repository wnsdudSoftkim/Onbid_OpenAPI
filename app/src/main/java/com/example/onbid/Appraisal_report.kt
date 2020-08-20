package com.example.onbid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onbid.data.Camco
import com.example.onbid.data.CamcoDetailTestData
import com.example.onbid.data.ViewModel
import kotlinx.android.synthetic.main.activity_appraisal_report.*
import kotlinx.android.synthetic.main.grid_fragment1.*
import retrofit2.Response

class Appraisal_report : AppCompatActivity() {
    val viewModel: ViewModel by viewModels()
    var CLTR_NO: String ?= ""
    var PBCT_NO: String ?= ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appraisal_report)
        btn_appraisal_backpress.setOnClickListener {
            onBackPressed()
        }

        CLTR_NO = intent.getStringExtra("CLTR_NO")
        PBCT_NO = intent.getStringExtra("PBCT_NO")
        if (CLTR_NO!=null &&PBCT_NO!=null) {
            initview()
        }
        viewModel.Liveappraisaldata.observe(this, Observer {
            if (viewModel.appraisaldata.size !=0) {
                val item = viewModel.appraisaldata[0]
                appraisal_1.setText(item.APSL_ASES_AMT)
                appraisal_2.setText(item.APSL_ASES_DT)
                appraisal_3.setText(item.APSL_ASES_ORG_NM)


            }
        })
    }
    fun initview() {
        if (viewModel.appraisaldata.size==0) {
            RetrofitClient.dataservice.getTestDetail(CLTR_NO!!,PBCT_NO!!)
                .enqueue(object : retrofit2.Callback<CamcoDetailTestData> {
                    override fun onFailure(call: retrofit2.Call<CamcoDetailTestData>, t: Throwable) {
                        Toast.makeText(applicationContext,""+t.message,Toast.LENGTH_LONG).show()
                        appraisal_1.setText(""+t.message)
                    }

                    override fun onResponse(
                        call: retrofit2.Call<CamcoDetailTestData>,
                        response: Response<CamcoDetailTestData>
                    ) {
                        val body = response.body()
                        //viewModel로 데이터를 보내줌.
                        if (body != null) {
                            viewModel.myappraisalSetData(body)

                        }
                    }

                })
        }

    }
}