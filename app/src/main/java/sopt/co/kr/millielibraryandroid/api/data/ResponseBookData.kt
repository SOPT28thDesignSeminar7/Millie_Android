package sopt.co.kr.millielibraryandroid.api.data

data class ResponseBookData(
    val status: Int,
    val data: BookList?
) {
    data class BookList(
        val books: ArrayList<BookInfo>
    )
}

