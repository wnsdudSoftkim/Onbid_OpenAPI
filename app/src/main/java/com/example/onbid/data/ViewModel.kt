package com.example.onbid.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {
    //데이터와 Livedata 선언
    val data = ArrayList<CamcoData_item>()
    val Livedata = MutableLiveData<ArrayList<CamcoData_item>>()


    fun mysHomeListSetData(item:Camco) {
        data.clear()
        val camco= item.body
        val camcodata = camco[0].items
        val camcoitems = camcodata[0].item
        for(i in 0 until camcoitems.size){
            data.add(camcoitems[i])
        }
        Livedata.value = data



    }
}