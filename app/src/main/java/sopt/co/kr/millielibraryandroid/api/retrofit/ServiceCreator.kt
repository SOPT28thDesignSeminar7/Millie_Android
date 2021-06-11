package sopt.co.kr.millielibraryandroid.api.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sopt.co.kr.millielibraryandroid.api.service.MilliService

object ServiceCreator {
    private const val BASE_URL = "http://3.36.64.41:5000/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val milliService: MilliService = retrofit.create(MilliService::class.java)
}