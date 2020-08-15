package com.example.onbid.data

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import java.io.Serializable


@Root(name = "response", strict = false)
data class CamcoDetailDataMoney @JvmOverloads constructor(
    @field:ElementList(name = "body", inline = true)
    @param:ElementList(name = "body", inline = true)
    val body: List<CamcoDataDetailMoney>
) : Serializable


@Root(name = "body", strict = false)
data class CamcoDataDetailMoney @JvmOverloads constructor(
    @field:ElementList(name = "items", inline = true)
    @param:ElementList(name = "items", inline = true)
    val items: List<CamcoData_itemsDetailMoney>
)

@Root(name = "items", strict = false)
data class CamcoData_itemsDetailMoney @JvmOverloads constructor(
    @field:ElementList(name = "item", inline = true)
    @param:ElementList(name = "item", inline = true)
    val item: List<CamcoData_item_DetailMoney>

)

@Root(name = "item", strict = false)
data class CamcoData_item_DetailMoney @JvmOverloads constructor(
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
    val CLTR_HSTR_NO: String? = "",
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

    //최초공고일자
    @field:Element(name = "TFRT_PLNM_DT", required = false)
    @param:Element(name = "TFRT_PLNM_DT", required = false)
    val TFRT_PLNM_DT: String? = "",
    //경쟁방식
    @field:Element(name = "CPTN_MTD_NM", required = false)
    @param:Element(name = "CPTN_MTD_NM", required = false)
    val CPTN_MTD_NM: String? = "",

    //주식종류
    @field:Element(name = "SCRT_KIND", required = false)
    @param:Element(name = "SCRT_KIND", required = false)
    val SCRT_KIND: String? = "",
    //증권명
    @field:Element(name = "SCRT_NM", required = false)
    @param:Element(name = "SCRT_NM", required = false)
    val SCRT_NM: String? = "",
    //수량
    @field:Element(name = "QNTY", required = false)
    @param:Element(name = "QNTY", required = false)
    val QNTY: String? = "",
    //지분율
    @field:Element(name = "PCOS", required = false)
    @param:Element(name = "PCOS", required = false)
    val PCOS: String? = "",
    //주당액면가
    @field:Element(name = "STK_PER_DNMT_PRC", required = false)
    @param:Element(name = "STK_PER_DNMT_PRC", required = false)
    val STK_PER_DNMT_PRC: String? = "",
    //액면총액
    @field:Element(name = "DNMT_TOT_AMT", required = false)
    @param:Element(name = "DNMT_TOT_AMT", required = false)
    val DNMT_TOT_AMT: String? = "",
    //발행주식총수
    @field:Element(name = "ISU_STK_TOT_CNT", required = false)
    @param:Element(name = "ISU_STK_TOT_CNT", required = false)
    val ISU_STK_TOT_CNT: String? = "",
    //종목명
    @field:Element(name = "ITM_NM", required = false)
    @param:Element(name = "ITM_NM", required = false)
    val ITM_NM: String? = "",
    //대표자명
    @field:Element(name = "RPSV_NM", required = false)
    @param:Element(name = "RPSV_NM", required = false)
    val RPSV_NM: String? = "",
    //연락처
    @field:Element(name = "CTNO", required = false)
    @param:Element(name = "CTNO", required = false)
    val CTNO: String? = "",

    //설립일자
    @field:Element(name = "ETLS_DT", required = false)
    @param:Element(name = "ETLS_DT", required = false)
    val ETLS_DT: String? = "",
    //결산월
    @field:Element(name = "CSCT_MON", required = false)
    @param:Element(name = "CSCT_MON", required = false)
    val CSCT_MON: String? = "",
    //업종
    @field:Element(name = "TPBZ", required = false)
    @param:Element(name = "TPBZ", required = false)
    val TPBZ: String? = "",
    //주요제품
    @field:Element(name = "PRMR_MNFTR_GDS", required = false)
    @param:Element(name = "PRMR_MNFTR_GDS", required = false)
    val PRMR_MNFTR_GDS: String? = "",
    //회원권번호
    @field:Element(name = "MBS_SCRT_NO", required = false)
    @param:Element(name = "MBS_SCRT_NO", required = false)
    val MBS_SCRT_NO: String? = "",
    //회원권명
    @field:Element(name = "MMB_RGT_NM", required = false)
    @param:Element(name = "MMB_RGT_NM", required = false)
    val MMB_RGT_NM: String? = "",
    //위치 및 부근현황
    @field:Element(name = "POSI_ENV_PSCD", required = false)
    @param:Element(name = "POSI_ENV_PSCD", required = false)
    val POSI_ENV_PSCD: String? = "",
    //이용현황
    @field:Element(name = "UTLZ_PSCD", required = false)
    @param:Element(name = "UTLZ_PSCD", required = false)
    val UTLZ_PSCD: String? = "",
    //기타사항
    @field:Element(name = "ETC_DTL_CNTN", required = false)
    @param:Element(name = "ETC_DTL_CNTN", required = false)
    val ETC_DTL_CNTN: String? = "",
    //매각금융회사
    @field:Element(name = "DPSL_FINC_COMP", required = false)
    @param:Element(name = "DPSL_FINC_COMP", required = false)
    val DPSL_FINC_COMP: String? = "",
    //부실채권종류
    @field:Element(name = "POOR_BOND_KIND", required = false)
    @param:Element(name = "POOR_BOND_KIND", required = false)
    val POOR_BOND_KIND: String? = "",
    //채권금액
    @field:Element(name = "BOND_AMT", required = false)
    @param:Element(name = "BOND_AMT", required = false)
    val BOND_AMT: String? = "",
    //양도자산확정일시
    @field:Element(name = "HDOR_AST_FIX_DY", required = false)
    @param:Element(name = "HDOR_AST_FIX_DY", required = false)
    val HDOR_AST_FIX_DY: String? = "",
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






