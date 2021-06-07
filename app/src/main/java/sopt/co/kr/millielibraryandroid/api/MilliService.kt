package sopt.co.kr.millielibraryandroid.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import sopt.co.kr.millielibraryandroid.api.data.ResponseBookData

interface MilliService {
    @GET("api/books")
    fun getBookList(): Call<List<ResponseBookData.BookInfo>>
}