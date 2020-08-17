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
                car_RGST_DEPT_NM.setText(a.RGST_DEPT_NM)
                car_PSCG_NM.setText(a.PSCG_NM)
                car_PSCG_TPNO.setText(a.PSCG_TPNO)
                car_LDNM_ADRS.setText(a.LDNM_ADRS)
                car_NMRD_ADRS.setText(a.NMRD_ADRS)
                car_CLTR_MNMT_NO.setText(a.CLTR_MNMT_NO)
                car_PRPT_DVSN_NM.setText(a.PRPT_DVSN_NM)
                car_DLGT_ORG_NM.setText(a.DLGT_ORG_NM)
                car_CTGR_FULL_NM.setText(a.CTGR_FULL_NM)
                car_BID_MTD_NM.setText(a.BID_MTD_NM)
                car_GOODS_NM.setText(a.GOODS_NM)
                car_POSI_ENV_PSCD.setText(a.POSI_ENV_PSCD)
                car_MANF.setText(a.MANF)
                car_VHKN.setText(a.VHKN)
                car_MDL.setText(a.MDL)
                car_NRGT.setText(a.NRGT)
                car_VHC_NO.setText(a.VHC_NO)
                car_CSTD_PLC.setText(a.CSTD_PLC)
                car_QNTY.setText(a.QNTY)
                car_VHCL_MLGE.setText(a.VHCL_MLGE)
                car_GRBX.setText(a.GRBX)
                car_ENDPC.setText(a.ENDPC)
                car_FUEL.setText(a.FUEL)
                car_DLVR_PLC.setText(a.DLVR_PLC)
                car_MIN_BID_PRC.setText(a.MIN_BID_PRC)
                car_PCMT_PYMT_EPDT_CNTN.setText(a.PCMT_PYMT_EPDT_CNTN)
                car_BID_PRGN_NFT.setText(a.BID_PRGN_NFT)
                car_DLVR_RSBY.setText(a.DLVR_RSBY)
                car_ICDL_CDTN.setText(a.ICDL_CDTN)
                car_SHR_RQR_EPRT_DT.setText(a.SHR_RQR_EPRT_DT)
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