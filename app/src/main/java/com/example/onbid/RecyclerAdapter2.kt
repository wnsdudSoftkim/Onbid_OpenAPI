package com.example.onbid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onbid.data.CamcoData_item
import com.example.onbid.data.CamcoData_itemNoticeData

class RecyclerAdapter2(                  // 존나 어렵다 viewholder라는 놈을 꼭 쓴단는걸 기억하자
    var list: ArrayList<CamcoData_itemNoticeData>,
    val inflater: LayoutInflater
): RecyclerView.Adapter<RecyclerAdapter2.ViewHolder>(){
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val notice_number = view.findViewById<TextView>(R.id.notice_PLNM_NO)
        val notice_name = view.findViewById<TextView>(R.id.notice_PLNM_NM)
        val notice_companyname = view.findViewById<TextView>(R.id.notice_RSBY_DEPT)
        val notice_1 = view.findViewById<TextView>(R.id.notice_PRPT_DVSN_NM)
        val notice_day1 = view.findViewById<TextView>(R.id.notice_PLNM_DT)
        val notice_day2 = view.findViewById<TextView>(R.id.notice_PBCT_EXCT_DTM)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.calender_design,parent,false))
    }

    override fun getItemCount(): Int {         // 크게 필요x
        return list.size
    }
    fun setData(newData: ArrayList<CamcoData_itemNoticeData>) {
        list = newData
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerAdapter2.ViewHolder, position: Int) {
        holder.notice_number.setText(list[position].PLNM_NO)
        holder.notice_name.setText(list[position].PLNM_NM)
        holder.notice_companyname.setText(list[position].RSBY_DEPT)
        holder.notice_1.setText(list[position].PRPT_DVSN_NM)
        holder.notice_day1.setText(list[position].PLNM_DT)
        holder.notice_day2.setText(list[position].PBCT_EXCT_DTM)
    }
}