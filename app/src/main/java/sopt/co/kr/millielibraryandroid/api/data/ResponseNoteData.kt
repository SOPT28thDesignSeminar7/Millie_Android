package sopt.co.kr.millielibraryandroid.api.data

data class ResponseNoteData(
    val status: Int,
    val data: NoteList
) {
    data class NoteList(
        val books: ArrayList<CardInfo>
    )
}
