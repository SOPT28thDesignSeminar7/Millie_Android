package sopt.co.kr.millielibraryandroid.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import sopt.co.kr.millielibraryandroid.api.data.ResponseBookData
import sopt.co.kr.millielibraryandroid.api.data.ResponseNoteData

interface MilliService {
    @GET("api/books")
    fun getBookList(): Call<ResponseBookData>

    // path {id}
    // Query id?= ~~~
    @GET("api/highlights/{id}")
    fun getNoteList(
        @Path("id") dbKeyValue: String
    ): Call<ResponseNoteData>
}