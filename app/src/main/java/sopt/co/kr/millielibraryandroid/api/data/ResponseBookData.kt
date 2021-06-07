package sopt.co.kr.millielibraryandroid.api.data

data class ResponseBookData(
    val status: Int,
    val data: BookInfo?
) {
    data class BookInfo(
        val image: Int,
        val bookName: String,
        val bookWriter: String,
        val highLightNumber: String,
        val bookContent: String,
        val bookDate: String
    )
}

