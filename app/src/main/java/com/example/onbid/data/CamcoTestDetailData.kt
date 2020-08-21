package com.example.onbid.data

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import java.io.Serializable


@Root(name = "response", strict = false)
data class CamcoDetailTestData @JvmOverloads constructor(
    @field:ElementList(name = "body", inline = true)
    @param:ElementList(name = "body", inline = true)
    val body: List<CamcoDataTestDetail>
) : Serializable


@Root(name = "body", strict = false)
data class CamcoDataTestDetail @JvmOverloads constructor(
    @field:ElementList(name = "items", inline = true)
    @param:ElementList(name = "items", inline = true)
    val items: List<CamcoData_itemsTestDetail>
)

@Root(name = "items", strict = false)
data class CamcoData_itemsTestDetail @JvmOverloads constructor(
    @field:ElementList(name = "estimationInfo", inline = true)
    @param:ElementList(name = "estimationInfo", inline = true)
    val estimationInfo: List<CamcoData_item_TestDetail>
)

@Root(name = "estimationInfo", strict = false)
data class CamcoData_item_TestDetail @JvmOverloads constructor(
    //
    @field:Element(name = "RNUM", required = false)
    @param:Element(name = "RNUM", required = false)
    val RNUM: String? = "",
    //감정가
    @field:Element(name = "APSL_ASES_AMT", required = false)
    @param:Element(name = "APSL_ASES_AMT", required = false)
    val APSL_ASES_AMT: String? = "",
    //감정평가일자
    @field:Element(name = "APSL_ASES_DT", required = false)
    @param:Element(name = "APSL_ASES_DT", required = false)
    val APSL_ASES_DT: String? = "",
    //감정평가업체
    @field:Element(name = "APSL_ASES_ORG_NM", required = false)
    @param:Element(name = "APSL_ASES_ORG_NM", required = false)
    val APSL_ASES_ORG_NM: String? = ""

)






