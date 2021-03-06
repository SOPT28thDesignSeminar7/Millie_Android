package sopt.co.kr.millielibraryandroid.api.data

import com.google.gson.annotations.SerializedName

data class CardInfo(
    @SerializedName("_id") val id: String,
    @SerializedName("title") val cardTitle: String,
    @SerializedName("author") val author: String,
    @SerializedName("highlightCount") val highLightNumber: Int,
    @SerializedName("image") val image: String,
    @SerializedName("highlights") val highlights: List<HighLights>
)

data class HighLights(
    @SerializedName("highlightDate") val highlightDate: String,
    @SerializedName("highlightText") val highlightText: String
)