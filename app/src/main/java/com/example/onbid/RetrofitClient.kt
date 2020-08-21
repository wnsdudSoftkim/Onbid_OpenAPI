package com.example.onbid


import com.example.onbid.data.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.http.*


object RetrofitClient {
    //XML 데이터 retrofit
    val retrofit = Retrofit.Builder()
        .baseUrl("http://openapi.onbid.co.kr/openapi/services/")
        .addConverterFactory(SimpleXmlConverterFactory.createNonStrict())
        .client (OkHttpClient ())
        .build()
    val dataservice: DataService = retrofit.create(DataService::class.java)

    //상세조회 Retrofit
    val retrofitDetail = Retrofit.Builder()
        .baseUrl("http://openapi.onbid.co.kr/openapi/services/")
        .addConverterFactory(SimpleXmlConverterFactory.createNonStrict())
        .client (OkHttpClient ())
        .build()
    val dataserviceDetail: DataService = retrofitDetail.create(DataService::class.java)

}

//서버로 보내는 INPUT데이터
interface DataService {


    //베이스 URL 을 제외한 경로
    //캠코공매물건목록조회(상세)
    @GET("KamcoPblsalThingInquireSvc/getKamcoPbctCltrList?serviceKey=TqjIDWEFUiSaeznEMiLDt2X05LgJsJWP0Ja9xKpbEIbwBfiGFLQoAXV1kpXjBNLZSQyhHOzF5Vh%2Fm4wZE7XXug%3D%3D&numOfRows=100&pageNo=1&DPSL_MTD_CD=&CTGR_HIRK_ID=&CTGR_HIRK_ID_MID=&SIDO=&SGK=&EMD=&GOODS_PRICE_FROM=&GOODS_PRICE_TO=&OPEN_PRICE_FROM=&OPEN_PRICE_TO=&CLTR_NM=&PBCT_BEGN_DTM=&PBCT_CLS_DTM=&CLTR_MNMT_NO=&")
    fun getdata(): Call<Camco>
    //1.통합관심탑20물건목록조회(0001부동산/0002자동차,운송장비 / 0003물품[기계] / 0004 물품(기타) / 0005 권리,증권
    @GET("ThingInfoInquireSvc/getUnifyInterestTop20CltrList?serviceKey=TqjIDWEFUiSaeznEMiLDt2X05LgJsJWP0Ja9xKpbEIbwBfiGFLQoAXV1kpXjBNLZSQyhHOzF5Vh%2Fm4wZE7XXug%3D%3D&")
    fun getTop20(
        @Query("CTGR_TYPE_ID") CTGR_TYPE_ID: String,
        @Query("numOfRows") numOfRows:String,
        @Query("pageNo") pageNo:String
    ):Call<Camco>
    //2. 통합클릭탑20물건목록조회(코드 위와 동일)
    @GET("ThingInfoInquireSvc/getUnifyClickTop20CltrList?serviceKey=TqjIDWEFUiSaeznEMiLDt2X05LgJsJWP0Ja9xKpbEIbwBfiGFLQoAXV1kpXjBNLZSQyhHOzF5Vh%2Fm4wZE7XXug%3D%3D&")
    fun getclick20(
        @Query("CTGR_TYPE_ID") CTGR_TYPE_ID: String,
        @Query("numOfRows") numOfRows:String,
        @Query("pageNo") pageNo:String
    ):Call<Camco>
    //3. 통합50%체감물건조회(총 281개 받아야함.)
    @GET("ThingInfoInquireSvc/getUnifyDegression50PerCltrList?serviceKey=TqjIDWEFUiSaeznEMiLDt2X05LgJsJWP0Ja9xKpbEIbwBfiGFLQoAXV1kpXjBNLZSQyhHOzF5Vh%2Fm4wZE7XXug%3D%3D&CTGR_HIRK_ID=&SIDO=&SGK=&EMD=&GOODS_PRICE_FROM=&GOODS_PRICE_TO=&OPEN_PRICE_FROM=&OPEN_PRICE_TO=&CLTR_NM=&PBCT_BEGN_DTM=&PBCT_CLS_DTM=&CLTR_MNMT_NO=&numOfRows=10&pageNo=1&")
    fun get50 ():Call<Camco>
    //4.캠코공매공고목록조회(0001 수탁,유입재산 / 0002 압류재산 / 0003 국유재산 )
    @GET("KamcoPblsalThingInquireSvc/getKamcoPlnmPbctList?serviceKey=TqjIDWEFUiSaeznEMiLDt2X05LgJsJWP0Ja9xKpbEIbwBfiGFLQoAXV1kpXjBNLZSQyhHOzF5Vh%2Fm4wZE7XXug%3D%3D&numOfRows=10&pageNo=1&PRPT_DVSN_CD=&")
    fun getcalender():Call<CamcoNotice>
    //5.캠코공매일정 조회(조회시작년도)
    @GET("KamcoPblsalThingInquireSvc/getKamcoPbctSchedule?serviceKey=TqjIDWEFUiSaeznEMiLDt2X05LgJsJWP0Ja9xKpbEIbwBfiGFLQoAXV1kpXjBNLZSQyhHOzF5Vh%2Fm4wZE7XXug%3D%3D&stdt=&")
    fun getsellcalender():Call<Camco>
    //6.통합새로운목록조회
    @GET("ThingInfoInquireSvc/getUnifyNewCltrList?serviceKey=TqjIDWEFUiSaeznEMiLDt2X05LgJsJWP0Ja9xKpbEIbwBfiGFLQoAXV1kpXjBNLZSQyhHOzF5Vh%2Fm4wZE7XXug%3D%3D&DPSL_MTD_CD=&CTGR_HIRK_ID=&CTGR_HIRK_ID_MID=&SIDO=&SGK=&EMD=&GOODS_PRICE_FROM=&GOODS_PRICE_TO=&OPEN_PRICE_FROM=&OPEN_PRICE_TO=&CLTR_NM=&PBCT_BEGN_DTM=&PBCT_CLS_DTM=&CLTR_MNMT_NO=&numOfRows=10&pageNo=1&")
    fun getnewlist():Call<Camco>
    //6-1.통합 용도별 목록 조회(0001 임대 / 0002 매각)
    @GET("ThingInfoInquireSvc/getUnifyUsageCltr?serviceKey=TqjIDWEFUiSaeznEMiLDt2X05LgJsJWP0Ja9xKpbEIbwBfiGFLQoAXV1kpXjBNLZSQyhHOzF5Vh%2Fm4wZE7XXug%3D%3D&DPSL_MTD_CD=&CTGR_HIRK_ID=&CTGR_HIRK_ID_MID=&SIDO=&SGK=&EMD=&GOODS_PRICE_FROM=&GOODS_PRICE_TO=&OPEN_PRICE_FROM=&OPEN_PRICE_TO=&CLTR_NM=&PBCT_BEGN_DTM=&PBCT_CLS_DTM=&ORG_NM=&ORG_BASE_NO=&CLTR_MNMT_NO=&numOfRows=10&pageNo=1&")
    fun getThinginfo():Call<Camco>
    //6-2. 통합 마감임박 목록조회
    @GET("ThingInfoInquireSvc/getUnifyDeadlineCltrList?serviceKey=TqjIDWEFUiSaeznEMiLDt2X05LgJsJWP0Ja9xKpbEIbwBfiGFLQoAXV1kpXjBNLZSQyhHOzF5Vh%2Fm4wZE7XXug%3D%3D&DPSL_MTD_CD=&CTGR_HIRK_ID=&CTGR_HIRK_ID_MID=&SIDO=&SGK=&EMD=&GOODS_PRICE_FROM=&GOODS_PRICE_TO=&OPEN_PRICE_FROM=&OPEN_PRICE_TO=&CLTR_NM=&PBCT_BEGN_DTM=&PBCT_CLS_DTM=&CLTR_MNMT_NO=&numOfRows=10&pageNo=1&")
    fun getemergency():Call<Camco>
    //6-1-1. (자동차 상세조회 )

    @GET("ThingInfoInquireSvc/getUnifyUsageCltrBasicInfoDetail?serviceKey=TqjIDWEFUiSaeznEMiLDt2X05LgJsJWP0Ja9xKpbEIbwBfiGFLQoAXV1kpXjBNLZSQyhHOzF5Vh%2Fm4wZE7XXug%3D%3D&")
    fun getThingdetail(
        @Query("CLTR_NO") CLTR_NO: String,
        @Query("PBCT_NO") PBCT_NO:String
    ):Call<CamcoDetailData>
    @GET("ThingInfoInquireSvc/getUnifyUsageCltrBasicInfoDetail?serviceKey=TqjIDWEFUiSaeznEMiLDt2X05LgJsJWP0Ja9xKpbEIbwBfiGFLQoAXV1kpXjBNLZSQyhHOzF5Vh%2Fm4wZE7XXug%3D%3D&")
    fun getmachinedetail(
        @Query("CLTR_NO") CLTR_NO: String,
        @Query("PBCT_NO") PBCT_NO:String
    ):Call<CamcoDetailDataMachine>

    //통합수의계약가능목록조회
    @GET("ThingInfoInquireSvc/getUnifyPrivateContractCltrList?serviceKey=TqjIDWEFUiSaeznEMiLDt2X05LgJsJWP0Ja9xKpbEIbwBfiGFLQoAXV1kpXjBNLZSQyhHOzF5Vh%2Fm4wZE7XXug%3D%3D&DPSL_MTD_CD=0001&CTGR_HIRK_ID=&CTGR_HIRK_ID_MID=&SIDO=&SGK=&EMD=&GOODS_PRICE_FROM=&GOODS_PRICE_TO=&OPEN_PRICE_FROM=&OPEN_PRICE_TO=&CLTR_NM=&CLTR_MNMT_NO=&numOfRows=10&pageNo=1&")
    fun getcontract():Call<Camco>

    @GET("ThingInfoInquireSvc/getUnifyUsageCltrEstimationInfoDetail?serviceKey=TqjIDWEFUiSaeznEMiLDt2X05LgJsJWP0Ja9xKpbEIbwBfiGFLQoAXV1kpXjBNLZSQyhHOzF5Vh%2Fm4wZE7XXug%3D%3D&pageNo=1&numOfRows=1&")
    //감정평가서
    fun getTestDetail(
        @Query("CLTR_NO") CLTR_NO: String,
        @Query("PBCT_NO") PBCT_NO:String
    ):Call<CamcoDetailTestData>

    //회원권 및 유가증권 상세조회
    fun getThingdetailMoney(
        @Query("CLTR_NO") CLTR_NO: String,
        @Query("PBCT_NO") PBCT_NO:String
    ):Call<CamcoDetailDataMoney>
    //자동차 /운송장비(grid4) 상위 코드 12000
    @GET("KamcoPblsalThingInquireSvc/getKamcoPbctCltrList?serviceKey=TqjIDWEFUiSaeznEMiLDt2X05LgJsJWP0Ja9xKpbEIbwBfiGFLQoAXV1kpXjBNLZSQyhHOzF5Vh%2Fm4wZE7XXug%3D%3D&numOfRows=10&pageNo=1&DPSL_MTD_CD=&CTGR_HIRK_ID=12000&CTGR_HIRK_ID_MID=&SIDO=&SGK=&EMD=&GOODS_PRICE_FROM=&GOODS_PRICE_TO=&OPEN_PRICE_FROM=&OPEN_PRICE_TO=&CLTR_NM=&PBCT_BEGN_DTM=&PBCT_CLS_DTM=&CLTR_MNMT_NO=&")
    fun getCargrid4():Call<Camco>
    //권리 증권(grid6)상위 코드 11000
    @GET("KamcoPblsalThingInquireSvc/getKamcoPbctCltrList?serviceKey=TqjIDWEFUiSaeznEMiLDt2X05LgJsJWP0Ja9xKpbEIbwBfiGFLQoAXV1kpXjBNLZSQyhHOzF5Vh%2Fm4wZE7XXug%3D%3D&numOfRows=10&pageNo=1&DPSL_MTD_CD=&CTGR_HIRK_ID=11000&CTGR_HIRK_ID_MID=&SIDO=&SGK=&EMD=&GOODS_PRICE_FROM=&GOODS_PRICE_TO=&OPEN_PRICE_FROM=&OPEN_PRICE_TO=&CLTR_NM=&PBCT_BEGN_DTM=&PBCT_CLS_DTM=&CLTR_MNMT_NO=&")
    fun getMoneygrid6():Call<Camco>
    //검색통신
    @GET("ThingInfoInquireSvc/getUnifyUsageCltr?serviceKey=TqjIDWEFUiSaeznEMiLDt2X05LgJsJWP0Ja9xKpbEIbwBfiGFLQoAXV1kpXjBNLZSQyhHOzF5Vh%2Fm4wZE7XXug%3D%3D&DPSL_MTD_CD=&CTGR_HIRK_ID=&CTGR_HIRK_ID_MID=&SIDO=&SGK=&EMD=&GOODS_PRICE_FROM=&GOODS_PRICE_TO=&OPEN_PRICE_FROM=&OPEN_PRICE_TO=&PBCT_BEGN_DTM=&PBCT_CLS_DTM=&ORG_NM=&ORG_BASE_NO=&CLTR_MNMT_NO=&")
    fun getSearch(
        @Query("CLTR_NM")  CLTR_NM:String,
        @Query("numOfRows") numOfRows:String,
    @Query("pageNo") pageNo:String
    ):Call<Camco>
}




