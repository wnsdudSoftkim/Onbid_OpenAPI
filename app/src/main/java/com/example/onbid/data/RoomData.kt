package com.example.onbid.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey




@Entity
data class RoomData(
    @PrimaryKey
    val uid:Int,
    @ColumnInfo(name = "CLTR_NM")
    val CLTR_NM:String,
    @ColumnInfo(name = "APSL_ASES_AVG_AMT")
    val APSL_ASES_AVG_AMT:String,
    @ColumnInfo(name = "DPSL_MTD_NM")
    val DPSL_MTD_NM:String,
    @ColumnInfo(name = "BID_MTD_NM")
    val BID_MTD_NM:String
)