package com.example.onbid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        btn_search_backpress.setOnClickListener {
            onBackPressed()
        }
        //매각 or 임대 (처분방식)
        //DPSL_MTD_CD
        //물건명
        //CLTR_NM
        //물건종류(코드조회 상위)(11000 권리/증권 12000 자동차 13000 농축산 1400 어업 등등)
        //CTGR_HIRK_ID
    }
}