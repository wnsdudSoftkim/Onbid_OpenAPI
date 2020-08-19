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
import com.example.onbid.data.ViewModel
import kotlinx.android.synthetic.main.activity_fragment3.*
import kotlinx.android.synthetic.main.activity_search.*
import retrofit2.Response

class SearchActivity : AppCompatActivity() {
    val viewModel: ViewModel by viewModels()
    var result1: String? = ""
    var search: String? = ""
    var result3: String? = ""
    var result4: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        btn_search_backpress.setOnClickListener {
            onBackPressed()
        }
        result1 = intent.getStringExtra("result1")
        search = intent.getStringExtra("search")
        result3 = intent.getStringExtra("result3")
        result4 = intent.getStringExtra("result4")
        //매각 or 임대 (처분방식)
        //DPSL_MTD_CD
        //물건명
        //CLTR_NM
        //물건종류(코드조회 상위)(11000 권리/증권 12000 자동차 13000 농축산 1400 어업 등등)
        //CTGR_HIRK_ID
        if(result1 !=null && search!=null && result3 !=null && result4!=null) {
            initview()
        }
        viewModel.Livesearchdata.observe(this, Observer {
            if (viewModel.data != null) {
                val adapter =
                    RecyclerAdapter(
                        viewModel.searchdata,
                        LayoutInflater.from(this),
                        onClick = {
                            //여기서 통신을 바로 하고 통신이 완료될 때 까지 dialog 보여준다 통신이 완료되면 상세페이지로 이동하게끔 , data 를 intent 로 보내준다.
                            //물건정보조회 서비스의 상세조회API
                            val intent = Intent(this,Home_Detail_Car::class.java)
                            intent.putExtra("CLTR_NO",it.CLTR_NO)
                            intent.putExtra("PBCT_NO",it.PBCT_NO)
                            startActivity(intent)
                        })
                recycler_view_search.adapter = adapter
                recycler_view_search.layoutManager = LinearLayoutManager(this)
                recycler_view_search.adapter?.notifyDataSetChanged()
                (recycler_view_search.adapter as RecyclerAdapter).setData(it)
            }
        })
    }
    fun initview() {
        if(viewModel.searchdata!=null) {
            RetrofitClient.dataservice.getSearch(result1!!,search!!,result3!!,result4!!)
                .enqueue(object : retrofit2.Callback<Camco> {
                    override fun onFailure(call: retrofit2.Call<Camco>, t: Throwable) {
                        Toast.makeText(applicationContext, "리스트를 읽어오는데 실패하였습니다"+t.message, Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(
                        call: retrofit2.Call<Camco>,
                        response: Response<Camco>
                    ) {
                        val body = response.body()
                        //viewModel로 데이터를 보내줌.
                        if (body != null) {
                            viewModel.mySearchData(response.body()!!)

                        }
                    }

                })

        }
    }
}