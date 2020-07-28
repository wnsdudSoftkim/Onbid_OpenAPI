package com.example.onbid


import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header


object RetrofitClient {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://openapi.onbid.co.kr/openapi/services/")
        .addConverterFactory(SimpleXmlConverterFactory.createNonStrict())
        .client (OkHttpClient ())
        .build()
    val dataservice: DataService = retrofit.create(DataService::class.java)

}

//서버로 보내는 INPUT데이터
interface DataService {
    //베이스 URL 을 제외한 경로

    @GET("KamcoPblsalThingInquireSvc/getKamcoPbctCltrList?serviceKey=TqjIDWEFUiSaeznEMiLDt2X05LgJsJWP0Ja9xKpbEIbwBfiGFLQoAXV1kpXjBNLZSQyhHOzF5Vh%2Fm4wZE7XXug%3D%3D&numOfRows=10&pageNo=1")
    fun getdata(): Call<Camco>
}




