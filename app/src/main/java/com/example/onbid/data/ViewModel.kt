package com.example.onbid.data

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onbid.RetrofitClient
import retrofit2.Response

class ViewModel : ViewModel() {
    //데이터와 Livedata 선언
    val data = ArrayList<CamcoData_item>()
    val logindata = ArrayList<LoginData>()
    val grid1fragment1data = ArrayList<CamcoData_item>()
    val grid1fragment2data = ArrayList<CamcoData_item>()
    val grid1fragment3data = ArrayList<CamcoData_item>()
    val grid1fragment4data = ArrayList<CamcoData_item>()


    val Livedata = MutableLiveData<ArrayList<CamcoData_item>>()
    val Livelogindata = MutableLiveData<ArrayList<LoginData>>()
    val Livegrid1fragment1data = MutableLiveData<ArrayList<CamcoData_item>>()
    val Livegrid1fragment2data = MutableLiveData<ArrayList<CamcoData_item>>()
    val Livegrid1fragment3data = MutableLiveData<ArrayList<CamcoData_item>>()
    val Livegrid1fragment4data = MutableLiveData<ArrayList<CamcoData_item>>()


    fun mysHomeListSetData(item: Camco) {
        data.clear()
        val a = item.body[0].items[0].item
        for ( i in 0 until a.size ) {
            data.add(a[i])
        }
        Livedata.value = data

    }

    fun setLoginData(item: LoginData) {
        logindata.add(item)
        Livelogindata.value = logindata

    }

    fun myGrid1Fragment1SetData(item:Camco) {
        grid1fragment1data.clear()

        val a = item.body[0].items[0].item
        for ( i in 0 until a.size ) {
            grid1fragment1data.add(a[i])
        }
        Livegrid1fragment1data.value = grid1fragment1data

    }
    fun myGrid1Fragment2SetData(item:Camco) {
        grid1fragment2data.clear()

        val a = item.body[0].items[0].item
        for ( i in 0 until a.size ) {
            grid1fragment2data.add(a[i])
        }
        Livegrid1fragment2data.value = grid1fragment2data

    }
    fun myGrid1Fragment3SetData(item: Camco) {
        grid1fragment3data.clear()

        val a = item.body[0].items[0].item
        for ( i in 0 until a.size ) {
            grid1fragment3data.add(a[i])
        }
        Livegrid1fragment3data.value = grid1fragment3data

    }
    fun myGrid1Fragment4SetData(item: Camco) {
        grid1fragment4data.clear()

        val a = item.body[0].items[0].item
        for (i in 0 until a.size) {
            grid1fragment4data.add(a[i])
        }
        Livegrid1fragment4data.value = grid1fragment4data
    }
}