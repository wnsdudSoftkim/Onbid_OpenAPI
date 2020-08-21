package com.example.onbid.data

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import java.io.Serializable


@Root(name = "response", strict = false)
data class CamcoNotice @JvmOverloads constructor(
    @field:ElementList(name = "body", inline = true)
    @param:ElementList(name = "body", inline = true)
    val body: List<CamcoNoticeData>
):Serializable



@Root(name = "body", strict = false)
data class CamcoNoticeData @JvmOverloads constructor(
    @field:ElementList(name = "items", inline = true)
    @param:ElementList(name = "items", inline = true)
    val items: List<CamcoData_itemsNoticeData>
)

@Root(name = "items",strict = false)
data class CamcoData_itemsNoticeData @JvmOverloads constructor(
    @field:ElementList(name = "item", inline = true)
    @param:ElementList(name = "item", inline = true)
    val item: List<CamcoData_itemNoticeData>

)
@Root(name = "item",strict = false)
data class CamcoData_itemNoticeData @JvmOverloads constructor(
    @field:Element(name = "RNUM", required = false)
    @param:Element(name = "RNUM", required = false)
    val RNUM: String? = "",
    //공고번호
    @field:Element(name = "PLNM_NO", required = false)
    @param:Element(name = "PLNM_NO", required = false)
    val PLNM_NO: String? = "",

    //공매번호
    @field:Element(name = "PBCT_NO", required = false)
    @param:Element(name = "PBCT_NO", required = false)
    val PBCT_NO: String? = "",

    //재산구분
    @field:Element(name = "PRPT_DVSN_NM", required = false)
    @param:Element(name = "PRPT_DVSN_NM", required = false)
    val PRPT_DVSN_NM: String? = "",

    //자산구분
    @field:Element(name = "AST_DVSN_NM", required = false)
    @param:Element(name = "AST_DVSN_NM", required = false)
    val AST_DVSN_NM: String? = "",

    //공고명
    @field:Element(name = "PLNM_NM", required = false)
    @param:Element(name = "PLNM_NM", required = false)
    val PLNM_NM: String? = "",

    //담당부점
    @field:Element(name = "RSBY_DEPT", required = false)
    @param:Element(name = "RSBY_DEPT", required = false)
    val RSBY_DEPT: String? = "",

    //공고관리번호
    @field:Element(name = "PLNM_MNMT_NO", required = false)
    @param:Element(name = "PLNM_MNMT_NO", required = false)
    val PLNM_MNMT_NO: String? = "",

    //공고일
    @field:Element(name = "PLNM_DT", required = false)
    @param:Element(name = "PLNM_DT", required = false)
    val PLNM_DT: String? = "",

    //개찰일시
    @field:Element(name = "PBCT_EXCT_DTM", required = false)
    @param:Element(name = "PBCT_EXCT_DTM", required = false)
    val PBCT_EXCT_DTM: String? = ""


)



