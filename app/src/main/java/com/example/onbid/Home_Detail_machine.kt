package com.example.onbid

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.onbid.data.CamcoDetailData
import com.example.onbid.data.CamcoDetailDataMachine
import com.example.onbid.data.ViewModel
import kotlinx.android.synthetic.main.activity_home__detail__car.*
import kotlinx.android.synthetic.main.activity_home__detail_machine.*
import retrofit2.Response

class Home_Detail_machine : AppCompatActivity() {
    val viewModel: ViewModel by viewModels()
    var CLTR_NO: String? = ""
    var PBCT_NO: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home__detail_machine)
        CLTR_NO = intent.getStringExtra("CLTR_NO")
        PBCT_NO = intent.getStringExtra("PBCT_NO")
        if (CLTR_NO != null && PBCT_NO != null) {
            initView()
        }
        btn_machine_backpress.setOnClickListener {
            onBackPressed()
        }
        btn_go_machine.setOnClickListener {
            val intent  = Intent(Intent.ACTION_VIEW, Uri.parse(("https://www.onbid.co.kr/op/cta/cltrdtl/collateralDetailMoveableAssetsList.do")))
            startActivity(intent)
        }
        btn_machine_popup.setOnClickListener {
            val intent = Intent(this,Appraisal_report::class.java)
            intent.putExtra("CLTR_NO",CLTR_NO)
            intent.putExtra("PBCT_NO",PBCT_NO)
            startActivity(intent)
        }
        viewModel.Livemachinedata.observe(this, Observer {
            val a = viewModel.homedetailmachine[0]
            machinep_MIN_BID_PRC.setText(a.MIN_BID_PRC)
            machine_CLTR_NM.setText(a.CLTR_NM)
            machine_CTGR_TYPE_NM.setText(a.CTGR_TYPE_NM)
            machine_DPSL_MTD_NM.setText(a.DPSL_MTD_NM)
            machine_PBCT_CLTR_STAT_NM.setText(a.PBCT_CLTR_STAT_NM)
            machine_ORG_NM.setText(a.ORG_NM)
            machine_RGST_DEPT_NM.setText(a.RGST_DEPT_NM)
            machine_PSCG_NM.setText(a.PSCG_NM)
            machine_PSCG_TPNO.setText(a.PSCG_TPNO)
            machine_LDNM_ADRS.setText(a.LDNM_ADRS)
            machine_NMRD_ADRS.setText(a.NMRD_ADRS)
            machine_CLTR_MNMT_NO.setText(a.CLTR_MNMT_NO)
            machine_PRPT_DVSN_NM.setText(a.PRPT_DVSN_NM)
            machine_DLGT_ORG_NM.setText(a.DLGT_ORG_NM)
            machine_CTGR_FULL_NM.setText(a.CTGR_FULL_NM)
            machine_BID_MTD_NM.setText(a.BID_MTD_NM)
            machine_TFRT_PLNM_DT.setText(a.TFRT_PLNM_DT)
            machine_GOODS_NM.setText(a.GOODS_NM)
            machine_POSI_ENV_PSCD.setText(a.POSI_ENV_PSCD)
            machine_MANF.setText(a.MANF)
            machine_MDL.setText(a.MDL)
            machine_NRGT.setText(a.NRGT)
            machine_STND.setText(a.STND)
            machine_PSNS_SIZE.setText(a.PSNS_SIZE)
            machine_PRDN_PLC_CTFR.setText(a.PRDN_PLC_CTFR)
            machine_USE_TERM.setText(a.USE_TERM)
            machine_WGHT_QNTY.setText(a.WGHT_QNTY)
            machine_QNTY.setText(a.QNTY)
            machine_CSTD_PLC.setText(a.CSTD_PLC)
            machine_ETC_DTL_CNTN.setText(a.ETC_DTL_CNTN)
            machine_MIN_BID_PRC.setText(a.MIN_BID_PRC)
            machine_PCMT_PYMT_EPDT_CNTN.setText(a.PCMT_PYMT_EPDT_CNTN)
            machine_BID_PRGN_NFT.setText(a.BID_PRGN_NFT)
            machine_DLVR_RSBY.setText(a.DLVR_RSBY)
            machine_ICDL_CDTN.setText(a.ICDL_CDTN)
            machine_SHR_RQR_EPRT_DT.setText(a.SHR_RQR_EPRT_DT)
        })

    }fun initView() {
        if (viewModel.homedetailmachine != null) {
            RetrofitClient.dataservice.getmachinedetail(CLTR_NO!!, PBCT_NO!!)
                .enqueue(object : retrofit2.Callback<CamcoDetailDataMachine> {
                    override fun onFailure(call: retrofit2.Call<CamcoDetailDataMachine>, t: Throwable) {
                        Toast.makeText(
                            this@Home_Detail_machine,
                            "리스트를 읽어오는데 실패하였습니다",
                            Toast.LENGTH_LONG
                        ).show()


                    }

                    override fun onResponse(
                        call: retrofit2.Call<CamcoDetailDataMachine>,
                        response: Response<CamcoDetailDataMachine>
                    ) {
                        val body = response.body()
                        //viewModel로 데이터를 보내줌.
                        if (body != null) {
                            viewModel.mymachineData(body)

                        }
                    }

                })

        }

    }
}