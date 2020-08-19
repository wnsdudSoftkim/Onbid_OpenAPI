package com.example.onbid.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {
    //데이터와 Livedata 선언
    val data = ArrayList<CamcoData_item>()
    val logindata = ArrayList<LoginData>()
    val grid1fragment1data = ArrayList<CamcoData_item>()
    val grid1fragment2data = ArrayList<CamcoData_item>()
    val grid1fragment3data = ArrayList<CamcoData_item>()
    val grid1fragment4data = ArrayList<CamcoData_item>()
    val grid3data = ArrayList<CamcoData_item>()
    val grid4data = ArrayList<CamcoData_item>()
    val grid5data = ArrayList<CamcoData_item>()
    val grid6data = ArrayList<CamcoData_item>()
    val homedetaildata = ArrayList<CamcoData_item_Detail>()
    val homedetaildatamoney = ArrayList<CamcoData_item_DetailMoney>()
    val noticedata = ArrayList<CamcoData_itemNoticeData>()


    val Livedata = MutableLiveData<ArrayList<CamcoData_item>>()
    val Livelogindata = MutableLiveData<ArrayList<LoginData>>()
    val Livegrid1fragment1data = MutableLiveData<ArrayList<CamcoData_item>>()
    val Livegrid1fragment2data = MutableLiveData<ArrayList<CamcoData_item>>()
    val Livegrid1fragment3data = MutableLiveData<ArrayList<CamcoData_item>>()
    val Livegrid1fragment4data = MutableLiveData<ArrayList<CamcoData_item>>()
    val Livegrid3data  = MutableLiveData<ArrayList<CamcoData_item>>()
    val Livegrid4data  = MutableLiveData<ArrayList<CamcoData_item>>()
    val Livegrid5data  = MutableLiveData<ArrayList<CamcoData_item>>()
    val Livegrid6data  = MutableLiveData<ArrayList<CamcoData_item>>()
    val LiveHomedetaildata = MutableLiveData<ArrayList<CamcoData_item_Detail>>()
    val LiveHomedetailmoneydata = MutableLiveData<ArrayList<CamcoData_item_DetailMoney>>()
    val Livenoticedata  = MutableLiveData<ArrayList<CamcoData_itemNoticeData>>()



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
    fun myGrid3SetData(item:Camco) {
        grid3data.clear()

        val a = item.body[0].items[0].item
        for ( i in 0 until a.size ) {
            grid3data.add(a[i])
        }

        Livegrid3data.value = grid3data

    }
    fun myGrid4SetData(item:Camco) {
        grid4data.clear()

        val a = item.body[0].items[0].item
        for ( i in 0 until a.size ) {
            grid4data.add(a[i])
        }

        Livegrid4data.value = grid4data

    }
    fun myGrid5SetData(item:Camco) {
        grid5data.clear()

        val a = item.body[0].items[0].item
        for ( i in 0 until a.size ) {
            grid5data.add(a[i])
        }

        Livegrid5data.value = grid5data

    }
    fun myGrid6SetData(item:Camco) {
        grid6data.clear()

        val a = item.body[0].items[0].item
        for ( i in 0 until a.size ) {
            grid6data.add(a[i])
        }

        Livegrid6data.value = grid6data

    }
    fun myhomedetailData(item:CamcoDetailData) {
        homedetaildata.clear()

        val a = item.body[0].items[0].item
        for ( i in 0 until a.size ) {
            homedetaildata.add(a[i])
        }

        LiveHomedetaildata.value = homedetaildata

    }
    fun myhomedetailMoneyData(item:CamcoDetailDataMoney) {
        homedetaildatamoney.clear()

        val a = item.body[0].items[0].item
        for ( i in 0 until a.size ) {
            homedetaildatamoney.add(a[i])
        }

        LiveHomedetailmoneydata.value = homedetaildatamoney

    }
    fun myNoticeData(item:CamcoNotice) {
        noticedata.clear()

        val a = item.body[0].items[0].item
        for ( i in 0 until a.size ) {
            noticedata.add(a[i])
        }

        Livenoticedata.value = noticedata

    }
}