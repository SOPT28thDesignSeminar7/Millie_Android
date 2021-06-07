package sopt.co.kr.millielibraryandroid.api.data

import com.google.gson.annotations.SerializedName

data class BookInfo(
    @SerializedName("_id") val id: String,
    @SerializedName("image") val image: String,
    @SerializedName("title") val bookName: String,
    @SerializedName("author") val bookWriter: String,
    @SerializedName("highlightCount") val highLightNumber: Int,
    @SerializedName("highlights") val hightlights: ArrayList<HighLight>,
)

data class HighLight(
    @SerializedName("highlightDate") val highlightDate: String,
    @SerializedName("hightlightText") val highlightText: String
)