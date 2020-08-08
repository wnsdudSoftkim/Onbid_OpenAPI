package com.example.onbid.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {
    //데이터와 Livedata 선언
    val data = ArrayList<CamcoData_item>()
    val logindata = ArrayList<LoginData>()
    val grid1fragment1data = ArrayList<CamcoData_item>()


    val Livedata = MutableLiveData<ArrayList<CamcoData_item>>()
    val Livelogindata = MutableLiveData<ArrayList<LoginData>>()
    val Livegrid1fragment1data = MutableLiveData<ArrayList<CamcoData_item>>()


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

    fun myGrid1Fragment1SetData(item: Camco) {
        grid1fragment1data.clear()
        val a = item.body[0].items[0].item
        for ( i in 0 until a.size ) {
            grid1fragment1data.add(a[i])
        }
        Livegrid1fragment1data.value = grid1fragment1data

    }
}