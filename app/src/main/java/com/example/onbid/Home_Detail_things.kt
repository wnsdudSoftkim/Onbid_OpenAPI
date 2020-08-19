package com.example.onbid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.onbid.data.CamcoDetailDataMoney
import com.example.onbid.data.ViewModel
import kotlinx.android.synthetic.main.activity_home__detail__car.*
import kotlinx.android.synthetic.main.activity_home__detail_things.*
import retrofit2.Response

class Home_Detail_things : AppCompatActivity() {
    val viewModel: ViewModel by viewModels()
    var CLTR_NO: String ?= ""
    var PBCT_NO: String ?= ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home__detail_things)
        btn_cardetail_backpress.setOnClickListener {
            onBackPressed()
        }
        btn_things_popup.setOnClickListener {
            val intent = Intent(this,Appraisal_report::class.java)
            intent.putExtra("CLTR_NO",CLTR_NO)
            intent.putExtra("PBCT_NO",PBCT_NO)
            startActivity(intent)
        }
        CLTR_NO = intent.getStringExtra("CLTR_NO")
        PBCT_NO = intent.getStringExtra("PBCT_NO")
        if (CLTR_NO != null && PBCT_NO != null) {
            initView()
        }
        viewModel.LiveHomedetailmoneydata.observe(this, Observer {
            if (viewModel.homedetaildatamoney != null) {
                val a = viewModel.homedetaildatamoney[0]
                things_CTGR_TYPE_NM.setText(a.CTGR_TYPE_NM)
                things_DPSL_MTD_NM.setText(a.DPSL_MTD_NM)
                things_PBCT_CLTR_STAT_NM.setText(a.PBCT_CLTR_STAT_NM)
                things_ORG_NM.setText(a.ORG_NM)
                things_RGST_DEPT_NM.setText(a.RGST_DEPT_NM)
                things_PSCG_NM.setText(a.PSCG_NM)
                things_PSCG_TPNO.setText(a.PSCG_TPNO)
                things_LDNM_ADRS.setText(a.LDNM_ADRS)
                things_NMRD_ADRS.setText(a.NMRD_ADRS)
                things_CLTR_MNMT_NO.setText(a.CLTR_MNMT_NO)
                things_PRPT_DVSN_NM.setText(a.PRPT_DVSN_NM)
                things_DLGT_ORG_NM.setText(a.DLGT_ORG_NM)
                things_CTGR_FULL_NM.setText(a.CTGR_FULL_NM)
                things_BID_MTD_NM.setText(a.BID_MTD_NM)
                things_TFRT_PLNM_DT.setText(a.TFRT_PLNM_DT)
                things_CPTN_MTD_NM.setText(a.CPTN_MTD_NM)
                things_SCRT_KIND.setText(a.SCRT_KIND)
                things_SCRT_NM.setText(a.SCRT_NM)
                things_QNTY.setText(a.QNTY)
                things_PCOS.setText(a.PCOS)
                things_STK_PER_DNMT_PRC.setText(a.STK_PER_DNMT_PRC)
                things_DNMT_TOT_AMT.setText(a.DNMT_TOT_AMT)
                things_ISU_STK_TOT_CNT.setText(a.ISU_STK_TOT_CNT)
                things_ITM_NM.setText(a.ITM_NM)
                things_RPSV_NM.setText(a.RPSV_NM)
                things_CTNO.setText(a.CTNO)
                things_ETLS_DT.setText(a.ETLS_DT)
                things_CSCT_MON.setText(a.CSCT_MON)
                things_TPBZ.setText(a.TPBZ)
                things_PRMR_MNFTR_GDS.setText(a.PRMR_MNFTR_GDS)
                things_MBS_SCRT_NO.setText(a.MBS_SCRT_NO)
                things_MMB_RGT_NM.setText(a.MMB_RGT_NM)
                things_POSI_ENV_PSCD.setText(a.POSI_ENV_PSCD)
                things_UTLZ_PSCD.setText(a.UTLZ_PSCD)
                things_ETC_DTL_CNTN.setText(a.ETC_DTL_CNTN)
                things_DPSL_FINC_COMP.setText(a.DPSL_FINC_COMP)
                things_POOR_BOND_KIND.setText(a.POOR_BOND_KIND)
                things_BOND_AMT.setText(a.BOND_AMT)
                things_HDOR_AST_FIX_DY.setText(a.HDOR_AST_FIX_DY)
                things_MIN_BID_PRC.setText(a.MIN_BID_PRC)
                things_PCMT_PYMT_EPDT_CNTN.setText(a.PCMT_PYMT_EPDT_CNTN)
                things_BID_PRGN_NFT.setText(a.BID_PRGN_NFT)
                things_DLVR_RSBY.setText(a.DLVR_RSBY)
                things_ICDL_CDTN.setText(a.ICDL_CDTN)
                things_SHR_RQR_EPRT_DT.setText(a.SHR_RQR_EPRT_DT)
            }
        })

    }

    fun initView() {
        if (viewModel.homedetaildatamoney != null) {
            RetrofitClient.dataservice.getThingdetailMoney(CLTR_NO!!, PBCT_NO!!)
                .enqueue(object : retrofit2.Callback<CamcoDetailDataMoney> {
                    override fun onFailure(call: retrofit2.Call<CamcoDetailDataMoney>, t: Throwable) {
                        Toast.makeText(
                            this@Home_Detail_things,
                            "리스트를 읽어오는데 실패하였습니다"+t.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    override fun onResponse(
                        call: retrofit2.Call<CamcoDetailDataMoney>,
                        response: Response<CamcoDetailDataMoney>
                    ) {
                        val body = response.body()
                        //viewModel로 데이터를 보내줌.
                        if (body != null) {
                            viewModel.myhomedetailMoneyData(body)

                        }
                    }

                })

        }

    }
}