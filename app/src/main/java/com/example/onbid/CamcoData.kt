package com.example.onbid


import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root


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
    //공고 번호
    @field:Element(name = "PLNM_NO")
    @param:Element(name = "PLNM_NO")
    val PLNM_NO: String? = "",

    //공매 번호
    @field:Element(name = "PBCT_NO")
    @param:Element(name = "PBCT_NO")
    val PBCT_NO: String? = "",

    //공매조건번호
    @field:Element(name = "PBCT_CDTN_NO")
    @param:Element(name = "PBCT_CDTN_NO")
    val PBCT_CDTN_NO: String? = "",

    //물건번호
    @field:Element(name = "CLTR_NO")
    @param:Element(name = "CLTR_NO")
    val CLTR_NO: String? = "",
    //물건이력번호
    @field:Element(name = "CLTR_HSTR_NO")
    @param:Element(name = "CLTR_HSTR_NO")
    val CLTR_HSTR_NO: String? = "",
    //화면그룹코드
    @field:Element(name = "SCRN_GRP_CD")
    @param:Element(name = "SCRN_GRP_CD")
    val SCRN_GRP_CD: String? = "",
    //용도명
    @field:Element(name = "CTGR_FULL_NM")
    @param:Element(name = "CTGR_FULL_NM")
    val CTGR_FULL_NM: String? = "",
    //입찰번호
    @field:Element(name = "BID_MNMT_NO")
    @param:Element(name = "BID_MNMT_NO")
    val BID_MNMT_NO: String? = "",
    //물건명
    @field:Element(name = "CLTR_NM")
    @param:Element(name = "CLTR_NM")
    val CLTR_NM: String? = "",
    //물건관리번호
    @field:Element(name = "CLTR_MNMT_NO")
    @param:Element(name = "CLTR_MNMT_NO")
    val CLTR_MNMT_NO: String? = "",
    //물건소재지(지번)
    @field:Element(name = "LDNM_ADRS")
    @param:Element(name = "LDNM_ADRS")
    val LDNM_ADRS: String? = "",
    //물건소재지(도로명)
    @field:Element(name = "NMRD_ADRS")
    @param:Element(name = "NMRD_ADRS")
    val NMRD_ADRS: String? = "",
    //?
    @field:Element(name = "LDNM_PNU")
    @param:Element(name = "LDNM_PNU")
    val LDNM_PNU: String?= "",
    //처분방식코드
    @field:Element(name = "DPSL_MTD_CD")
    @param:Element(name = "DPSL_MTD_CD")
    val DPSL_MTD_CD: String? = "",
    //처분방식코드명
    @field:Element(name = "DPSL_MTD_NM")
    @param:Element(name = "DPSL_MTD_NM")
    val DPSL_MTD_NM: String? = "",
    //입찰방식명
    @field:Element(name = "BID_MTD_NM")
    @param:Element(name = "BID_MTD_NM")
    val BID_MTD_NM: String? = "",
    //최저입찰가
    @field:Element(name = "MIN_BID_PRC")
    @param:Element(name = "MIN_BID_PRC")
    val MIN_BID_PRC: String? = "",
    //감정가
    @field:Element(name = "APSL_ASES_AVG_AMT")
    @param:Element(name = "APSL_ASES_AVG_AMT")
    val APSL_ASES_AVG_AMTC: String? = "",
    //최저입찰가율
    @field:Element(name = "FEE_RATE")
    @param:Element(name = "FEE_RATE")
    val FEE_RATE: String? = "",
    //입찰시작일시
    @field:Element(name = "PBCT_BEGN_DTM")
    @param:Element(name = "PBCT_BEGN_DTM")
    val PBCT_BEGN_DTM: String? = "",
    //입찰마감일시
    @field:Element(name = "PBCT_CLS_DTM")
    @param:Element(name = "PBCT_CLS_DTM")
    val PBCT_CLS_DTM: String? = "",
    //물건상태
    @field:Element(name = "PBCT_CLTR_STAT_NM")
    @param:Element(name = "PBCT_CLTR_STAT_NM")
    val PBCT_CLTR_STAT_NM: String? = "",
    //유찰횟수
    @field:Element(name = "USCBD_CNT")
    @param:Element(name = "USCBD_CNT")
    val USCBD_CNT: String? = "",
    //조회수
    @field:Element(name = "IQRY_CNT")
    @param:Element(name = "IQRY_CNT")
    val IQRY_CNT: String? = "",
    //물건상세정보
    @field:Element(name = "GOODS_NM")
    @param:Element(name = "GOODS_NM")
    val GOODS_NM: String?= "",
    //제조사
    @field:Element(name = "MANF", required = false)
    @param:Element(name = "MANF", required = false)
    val MANF: String?= "",
    //모델
    @field:Element(name = "MDL", required = false)
    @param:Element(name = "MDL", required = false)
    val MDL: String? = "",
    //연월식
    @field:Element(name = "NRGT", required = false)
    @param:Element(name = "NRGT", required = false)
    val NRGT: String? = "",
    //변속기
    @field:Element(name = "GRBX", required = false)
    @param:Element(name = "GRBX", required = false)
    val GRBX: String? = "",
    //배기량
    @field:Element(name = "ENDPC", required = false)
    @param:Element(name = "ENDPC", required = false)
    val ENDPC: String? = "",
    //주행거리
    @field:Element(name = "VHCL_MLGE", required = false)
    @param:Element(name = "VHCL_MLGE", required = false)
    val VHCL_MLGE: String? = "",
    //연료
    @field:Element(name = "FUEL", required = false)
    @param:Element(name = "FUEL", required = false)
    val FUEL: String? = "",
    //법인명
    @field:Element(name = "SCRT_NM", required = false)
    @param:Element(name = "SCRT_NM", required = false)
    val SCRT_NM: String? = "",
    //업종
    @field:Element(name = "TPBZ", required = false)
    @param:Element(name = "TPBZ", required = false)
    val TPBZ: String? = "",
    //종목명
    @field:Element(name = "ITM_NM", required = false)
    @param:Element(name = "ITM_NM", required = false)
    val ITM_NM: String? = "",
    //회원권명
    @field:Element(name = "MMB_RGT_NM", required = false)
    @param:Element(name = "MMB_RGT_NM", required = false)
    val MMB_RGT_NM: String? = ""
)




