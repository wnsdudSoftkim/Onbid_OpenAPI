package com.example.onbid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onbid.data.CamcoData_item
import java.text.DecimalFormat

class RecyclerAdapter(
    var itemList: ArrayList<CamcoData_item>,
    val inflater: LayoutInflater,
    val onClick:(a: CamcoData_item) -> Unit
): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        val total_name = view.findViewById<TextView>(R.id.total_name)
        val total_money = view.findViewById<TextView>(R.id.total_money)
        val linear_detail = view.findViewById<LinearLayout>(R.id.linear_total_detail)
        val total_mini1 = view.findViewById<TextView>(R.id.text_total_mini1)
        val total_mini2 = view.findViewById<TextView>(R.id.text_total_mini2)

    }
    //데이터 변동사항 체크
    fun setData(newData: ArrayList<CamcoData_item>) {
        itemList = newData
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.total_main,parent,false))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val item = itemList[position]
        holder.total_name.setText(item.CLTR_NM)
        val a= item.APSL_ASES_AVG_AMT?.toLong()
        val formatter = DecimalFormat("###,###")
        val num = formatter.format(a)
        holder.total_money.setText(num.toString())
        holder.total_mini1.setText(item.DPSL_MTD_NM)
        holder.total_mini2.setText(item.BID_MTD_NM)
        holder.linear_detail.setOnClickListener {
            onClick.invoke(item)
        }

    }
}