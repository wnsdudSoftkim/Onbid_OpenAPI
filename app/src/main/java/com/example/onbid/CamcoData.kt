package com.example.onbid

import android.net.Uri
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import retrofit2.http.Url

@Root(name = "response", strict = false)
data class Camco @JvmOverloads constructor(
    @field:ElementList(name = "body", inline = true)
    @param:ElementList(name = "body", inline = true)
    val body: List<CamcoData>
)



@Root(name = "body", strict = false)
data class CamcoData @JvmOverloads constructor(
    @field:ElementList(name = "items", inline = true)
    @param:ElementList(name = "items", inline = true)
    val items: List<CamcoData_items>
)

@Root(name = "items",strict = false)
data class CamcoData_items @JvmOverloads constructor(
    @field:ElementList(name = "item", inline = true)
    @param:ElementList(name = "item", inline = true)
    val item: List<CamcoData_item>

)

@Root(name = "item",strict = false)
data class CamcoData_item @JvmOverloads constructor(
    @field:Element(name = "RNUM")
    @param:Element(name = "RNUM")
    val RNUM: String? = "",

    @field:Element(name = "PLNM_NO")
    @param:Element(name = "PLNM_NO")
    val PLNM_NO: String? = "",

    @field:Element(name = "PBCT_NO")
    @param:Element(name = "PBCT_NO")
    val PBCT_NO: String? = "",

    @field:Element(name = "PBCT_CDTN_NO")
    @param:Element(name = "PBCT_CDTN_NO")
    val PBCT_CDTN_NO: String? = "",
    @field:Element(name = "CLTR_NO")
    @param:Element(name = "CLTR_NO")
    val CLTR_NO: String? = "",
    @field:Element(name = "CLTR_HSTR_NO")
    @param:Element(name = "CLTR_HSTR_NO")
    val CLTR_HSTR_NO: String? = "",
    @field:Element(name = "SCRN_GRP_CD")
    @param:Element(name = "SCRN_GRP_CD")
    val SCRN_GRP_CD: String? = "",
    @field:Element(name = "CTGR_FULL_NM")
    @param:Element(name = "CTGR_FULL_NM")
    val CTGR_FULL_NM: String? = "",
    @field:Element(name = "BID_MNMT_NO")
    @param:Element(name = "BID_MNMT_NO")
    val BID_MNMT_NO: String? = "",
    @field:Element(name = "CLTR_NM")
    @param:Element(name = "CLTR_NM")
    val CLTR_NM: String? = "",
    @field:Element(name = "CLTR_MNMT_NO")
    @param:Element(name = "CLTR_MNMT_NO")
    val CLTR_MNMT_NO: String? = "",
    @field:Element(name = "LDNM_ADRS")
    @param:Element(name = "LDNM_ADRS")
    val LDNM_ADRS: String? = "",
    @field:Element(name = "NMRD_ADRS")
    @param:Element(name = "NMRD_ADRS")
    val NMRD_ADRS: String? = "",
    @field:Element(name = "LDNM_PNU")
    @param:Element(name = "LDNM_PNU")
    val LDNM_PNU: String?= "",
    @field:Element(name = "DPSL_MTD_CD")
    @param:Element(name = "DPSL_MTD_CD")
    val DPSL_MTD_CD: String? = "",
    @field:Element(name = "DPSL_MTD_NM")
    @param:Element(name = "DPSL_MTD_NM")
    val DPSL_MTD_NM: String? = "",
    @field:Element(name = "BID_MTD_NM")
    @param:Element(name = "BID_MTD_NM")
    val BID_MTD_NM: String? = "",
    @field:Element(name = "MIN_BID_PRC")
    @param:Element(name = "MIN_BID_PRC")
    val MIN_BID_PRC: String? = "",
    @field:Element(name = "APSL_ASES_AVG_AMT")
    @param:Element(name = "APSL_ASES_AVG_AMT")
    val APSL_ASES_AVG_AMTC: String? = "",
    @field:Element(name = "FEE_RATE")
    @param:Element(name = "FEE_RATE")
    val FEE_RATE: String? = "",
    @field:Element(name = "PBCT_BEGN_DTM")
    @param:Element(name = "PBCT_BEGN_DTM")
    val PBCT_BEGN_DTM: String? = "",
    @field:Element(name = "PBCT_CLS_DTM")
    @param:Element(name = "PBCT_CLS_DTM")
    val PBCT_CLS_DTM: String? = "",
    @field:Element(name = "PBCT_CLTR_STAT_NM")
    @param:Element(name = "PBCT_CLTR_STAT_NM")
    val PBCT_CLTR_STAT_NM: String? = "",
    @field:Element(name = "USCBD_CNT")
    @param:Element(name = "USCBD_CNT")
    val USCBD_CNT: String? = "",
    @field:Element(name = "IQRY_CNT")
    @param:Element(name = "IQRY_CNT")
    val IQRY_CNT: String? = "",
    @field:Element(name = "GOODS_NM")
    @param:Element(name = "GOODS_NM")
    val GOODS_NM: String?= "",
    @field:Element(name = "MANF", required = false)
    @param:Element(name = "MANF", required = false)
    val MANF: String?= "",
    @field:Element(name = "MDL", required = false)
    @param:Element(name = "MDL", required = false)
    val MDL: String? = "",
    @field:Element(name = "NRGT", required = false)
    @param:Element(name = "NRGT", required = false)
    val NRGT: String? = "",
    @field:Element(name = "GRBX", required = false)
    @param:Element(name = "GRBX", required = false)
    val GRBX: String? = "",
    @field:Element(name = "ENDPC", required = false)
    @param:Element(name = "ENDPC", required = false)
    val ENDPC: String? = "",
    @field:Element(name = "VHCL_MLGE", required = false)
    @param:Element(name = "VHCL_MLGE", required = false)
    val VHCL_MLGE: String? = "",
    @field:Element(name = "FUEL", required = false)
    @param:Element(name = "FUEL", required = false)
    val FUEL: String? = "",
    @field:Element(name = "SCRT_NM", required = false)
    @param:Element(name = "SCRT_NM", required = false)
    val SCRT_NM: String? = "",
    @field:Element(name = "TPBZ", required = false)
    @param:Element(name = "TPBZ", required = false)
    val TPBZ: String? = "",
    @field:Element(name = "ITM_NM", required = false)
    @param:Element(name = "ITM_NM", required = false)
    val ITM_NM: String? = "",
    @field:Element(name = "MMB_RGT_NM", required = false)
    @param:Element(name = "MMB_RGT_NM", required = false)
    val MMB_RGT_NM: String? = ""
)




