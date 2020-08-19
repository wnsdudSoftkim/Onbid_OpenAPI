package com.example.onbid.data

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import java.io.Serializable


@Root(name = "response", strict = false)
data class CamcoDetailData @JvmOverloads constructor(
    @field:ElementList(name = "body", inline = true)
    @param:ElementList(name = "body", inline = true)
    val body: List<CamcoDataDetail>
) : Serializable


@Root(name = "body", strict = false)
data class CamcoDataDetail @JvmOverloads constructor(
    @field:ElementList(name = "items", inline = true)
    @param:ElementList(name = "items", inline = true)
    val items: List<CamcoData_itemsDetail>
)

@Root(name = "items", strict = false)
data class CamcoData_itemsDetail @JvmOverloads constructor(
    @field:ElementList(name = "item", inline = true)
    @param:ElementList(name = "item", inline = true)
    val item: List<CamcoData_item_Detail>

)

@Root(name = "item", strict = false)
data class CamcoData_item_Detail @JvmOverloads constructor(
    //물건명
    @field:Element(name = "CLTR_NM", required = false)
    @param:Element(name = "CLTR_NM", required = false)
    val CLTR_NM: String? = "",
    //물건종류
    @field:Element(name = "CTGR_TYPE_NM", required = false)
    @param:Element(name = "CTGR_TYPE_NM", required = false)
    val CTGR_TYPE_NM: String? = "",

    //처분방식
    @field:Element(name = "DPSL_MTD_NM", required = false)
    @param:Element(name = "DPSL_MTD_NM", required = false)
    val DPSL_MTD_NM: String? = "",

    //물건상태(인터넷입찰 진행중 등등)
    @field:Element(name = "PBCT_CLTR_STAT_NM", required = false)
    @param:Element(name = "PBCT_CLTR_STAT_NM", required = false)
    val PBCT_CLTR_STAT_NM: String? = "",

    //입찰진행기관
    @field:Element(name = "ORG_NM", required = false)
    @param:Element(name = "ORG_NM", required = false)
    val ORG_NM: String? = "",
    //부서
    @field:Element(name = "RGST_DEPT_NM", required = false)
    @param:Element(name = "RGST_DEPT_NM", required = false)
    val RGST_DEPT_NM: String? = "",
    //담당자
    @field:Element(name = "PSCG_NM", required = false)
    @param:Element(name = "PSCG_NM", required = false)
    val PSCG_NM: String? = "",
    //담당자연락처
    @field:Element(name = "PSCG_TPNO", required = false)
    @param:Element(name = "PSCG_TPNO", required = false)
    val PSCG_TPNO: String? = "",
    //물건소재지(지번)
    @field:Element(name = "LDNM_ADRS", required = false)
    @param:Element(name = "LDNM_ADRS", required = false)
    val LDNM_ADRS: String? = "",
    //물건소재지(도로명)
    @field:Element(name = "NMRD_ADRS", required = false)
    @param:Element(name = "NMRD_ADRS", required = false)
    val NMRD_ADRS: String? = "",
    //물건관리번호
    @field:Element(name = "CLTR_MNMT_NO", required = false)
    @param:Element(name = "CLTR_MNMT_NO", required = false)
    val CLTR_MNMT_NO: String? = "",
    //재산종류
    @field:Element(name = "PRPT_DVSN_NM", required = false)
    @param:Element(name = "PRPT_DVSN_NM", required = false)
    val PRPT_DVSN_NM: String? = "",

    //위임기관
    @field:Element(name = "DLGT_ORG_NM", required = false)
    @param:Element(name = "DLGT_ORG_NM", required = false)
    val DLGT_ORG_NM: String? = "",
    //용도
    @field:Element(name = "CTGR_FULL_NM", required = false)
    @param:Element(name = "CTGR_FULL_NM", required = false)
    val CTGR_FULL_NM: String? = "",

    //입찰방식명
    @field:Element(name = "BID_MTD_NM", required = false)
    @param:Element(name = "BID_MTD_NM", required = false)
    val BID_MTD_NM: String? = "",

    //???
    @field:Element(name = "TFRT_PLNM_DT", required = false)
    @param:Element(name = "TFRT_PLNM_DT", required = false)
    val TFRT_PLNM_DT: String? = "",
    //물건상세정보
    @field:Element(name = "GOODS_NM", required = false)
    @param:Element(name = "GOODS_NM", required = false)
    val GOODS_NM: String? = "",

    //위치및 주변부근현황
    @field:Element(name = "POSI_ENV_PSCD", required = false)
    @param:Element(name = "POSI_ENV_PSCD", required = false)
    val POSI_ENV_PSCD: String? = "",
    //제조사
    @field:Element(name = "MANF", required = false)
    @param:Element(name = "MANF", required = false)
    val MANF: String? = "",
    //차종
    @field:Element(name = "VHKN", required = false)
    @param:Element(name = "VHKN", required = false)
    val VHKN: String? = "",
    //모델
    @field:Element(name = "MDL", required = false)
    @param:Element(name = "MDL", required = false)
    val MDL: String? = "",
    //연월식
    @field:Element(name = "NRGT", required = false)
    @param:Element(name = "NRGT", required = false)
    val NRGT: String? = "",
    //차량번호
    @field:Element(name = "VHC_NO", required = false)
    @param:Element(name = "VHC_NO", required = false)
    val VHC_NO: String? = "",
    //보관장소
    @field:Element(name = "CSTD_PLC", required = false)
    @param:Element(name = "CSTD_PLC", required = false)
    val CSTD_PLC: String? = "",
    //수량
    @field:Element(name = "QNTY", required = false)
    @param:Element(name = "QNTY", required = false)
    val QNTY :String? = "",
    //주행거리
    @field:Element(name = "VHCL_MLGE", required = false)
    @param:Element(name = "VHCL_MLGE", required = false)
    val VHCL_MLGE: String? = "",
    //변속기
    @field:Element(name = "GRBX", required = false)
    @param:Element(name = "GRBX", required = false)
    val GRBX: String? = "",

    //배기량
    @field:Element(name = "ENDPC", required = false)
    @param:Element(name = "ENDPC", required = false)
    val ENDPC: String? = "",
    //연료
    @field:Element(name = "FUEL", required = false)
    @param:Element(name = "FUEL", required = false)
    val FUEL: String? = "",
    //인도장소
    @field:Element(name = "DLVR_PLC", required = false)
    @param:Element(name = "DLVR_PLC", required = false)
    val DLVR_PLC: String? = "",
    //입찰시작가
    @field:Element(name = "MIN_BID_PRC", required = false)
    @param:Element(name = "MIN_BID_PRC", required = false)
    val MIN_BID_PRC: String? = "",
    //만기일
    @field:Element(name = "PCMT_PYMT_EPDT_CNTN", required = false)
    @param:Element(name = "PCMT_PYMT_EPDT_CNTN", required = false)
    val PCMT_PYMT_EPDT_CNTN: String? = "",
    //입찰회수
    @field:Element(name = "BID_PRGN_NFT", required = false)
    @param:Element(name = "BID_PRGN_NFT", required = false)
    val BID_PRGN_NFT: String? = "",
    //명도책임
    @field:Element(name = "DLVR_RSBY", required = false)
    @param:Element(name = "DLVR_RSBY", required = false)
    val DLVR_RSBY: String? = "",
    //부대조건
    @field:Element(name = "ICDL_CDTN", required = false)
    @param:Element(name = "ICDL_CDTN", required = false)
    val ICDL_CDTN: String? = "",
    //배분요구종기
    @field:Element(name = "SHR_RQR_EPRT_DT", required = false)
    @param:Element(name = "SHR_RQR_EPRT_DT", required = false)
    val SHR_RQR_EPRT_DT: String? = ""


)






