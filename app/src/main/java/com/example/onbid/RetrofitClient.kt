package com.example.onbid


import com.example.onbid.data.Camco
import com.example.onbid.data.LoginData
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.http.*


object RetrofitClient {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://openapi.onbid.co.kr/openapi/services/")
        .addConverterFactory(SimpleXmlConverterFactory.createNonStrict())
        .client (OkHttpClient ())
        .build()
    val dataservice: DataService = retrofit.create(DataService::class.java)
    //로그인,회원가입 retrofit
    val retrofitforlogin = Retrofit.Builder()
        .baseUrl("http://openapi.onbid.co.kr/openapi/services/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val loginservice :DataService = retrofitforlogin.create(DataService::class.java)

}

//서버로 보내는 INPUT데이터
interface DataService {
    //회원가입 POST
    @FormUrlEncoded
    @POST("app_login")
    fun SignUp(
        @Field("email") email:String,
        @Field("password") password:String,
        @Field("name") name:String
    ):Call<LoginData>
    //로그인 POST
    @FormUrlEncoded
    @POST("app_login")
    fun Login(
        @Field("email") email:String,
        @Field("password") password:String
    ):Call<LoginData>

    //베이스 URL 을 제외한 경로
    //캠코공매물건목록조회(상세)
    @GET("KamcoPblsalThingInquireSvc/getKamcoPbctCltrList?serviceKey=TqjIDWEFUiSaeznEMiLDt2X05LgJsJWP0Ja9xKpbEIbwBfiGFLQoAXV1kpXjBNLZSQyhHOzF5Vh%2Fm4wZE7XXug%3D%3D&numOfRows=10&pageNo=1&DPSL_MTD_CD=&CTGR_HIRK_ID=&CTGR_HIRK_ID_MID=&SIDO=&SGK=&EMD=&GOODS_PRICE_FROM=&GOODS_PRICE_TO=&OPEN_PRICE_FROM=&OPEN_PRICE_TO=&CLTR_NM=&PBCT_BEGN_DTM=&PBCT_CLS_DTM=&CLTR_MNMT_NO=&")
    fun getdata(): Call<Camco>

    //1.통합관심탑20물건목록조회(0001부동산/0002자동차,운송장비 / 0003물품[기계] / 0004 물품(기타) / 0005 권리,증권
    @GET("ThingInfoInquireSvc/getUnifyInterestTop20CltrList?serviceKey=TqjIDWEFUiSaeznEMiLDt2X05LgJsJWP0Ja9xKpbEIbwBfiGFLQoAXV1kpXjBNLZSQyhHOzF5Vh%2Fm4wZE7XXug%3D%3D&")
    fun getTop20(
        @Query("CTGR_TYPE_ID") CTGR_TYPE_ID: String,
        @Query("numOfRows") numOfRows:String,
        @Query("pageNo") pageNo:String
    ):Call<Camco>
    //2. 통합클릭탑20물건목록조회(코드 위와 동일)
    @GET("ThingInfoInquireSvc/getUnifyClickTop20CltrList?serviceKey=TqjIDWEFUiSaeznEMiLDt2X05LgJsJWP0Ja9xKpbEIbwBfiGFLQoAXV1kpXjBNLZSQyhHOzF5Vh%2Fm4wZE7XXug%3D%3D&CTGR_TYPE_ID=&numOfRows=10&pageNo=1")
    fun getclick20():Call<Camco>
    //3. 통합50%체감물건조회
    @GET("ThingInfoInquireSvc/getUnifyDegression50PerCltrList?serviceKey=TqjIDWEFUiSaeznEMiLDt2X05LgJsJWP0Ja9xKpbEIbwBfiGFLQoAXV1kpXjBNLZSQyhHOzF5Vh%2Fm4wZE7XXug%3D%3D&CTGR_HIRK_ID=&SIDO=&SGK=&EMD=&GOODS_PRICE_FROM=&GOODS_PRICE_TO=&OPEN_PRICE_FROM=&OPEN_PRICE_TO=&CLTR_NM=&PBCT_BEGN_DTM=&PBCT_CLS_DTM=&CLTR_MNMT_NO=&numOfRows=10&pageNo=1")
    fun get50 ():Call<Camco>
    //4.캠코공매공고목록조회(0001 수탁,유입재산 / 0002 압류재산 / 0003 국유재산 )
    @GET("KamcoPblsalThingInquireSvc/getKamcoPlnmPbctList?serviceKey=TqjIDWEFUiSaeznEMiLDt2X05LgJsJWP0Ja9xKpbEIbwBfiGFLQoAXV1kpXjBNLZSQyhHOzF5Vh%2Fm4wZE7XXug%3D%3D&numOfRows=10&pageNo=1&PRPT_DVSN_CD=&")
    fun getcalender():Call<Camco>
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
    fun getThingup():Call<Camco>
    //6-1-1. 통합용도별 물건 상세조회(물건번호, 공매번호 필수 !!!)
    @GET("ThingInfoInquireSvc/getUnifyUsageCltrBasicInfoDetail?serviceKey=TqjIDWEFUiSaeznEMiLDt2X05LgJsJWP0Ja9xKpbEIbwBfiGFLQoAXV1kpXjBNLZSQyhHOzF5Vh%2Fm4wZE7XXug%3D%3D&CLTR_NO=1226758&PBCT_NO=9301922&")
    fun getThingdetail():Call<Camco>


}




