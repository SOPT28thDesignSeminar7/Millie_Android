package sopt.co.kr.millielibraryandroid.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import sopt.co.kr.millielibraryandroid.api.data.ResponseBookData
import sopt.co.kr.millielibraryandroid.api.data.ResponseNoteData

interface MilliService {
    @GET("api/books")
    fun getBookList(): Call<ResponseBookData>

    @GET("api/highlights/:id")
    fun getNoteList(
        @Path("id") bookId :Int
    ) : Call<ResponseNoteData>
}