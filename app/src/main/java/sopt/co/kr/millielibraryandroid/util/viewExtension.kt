package sopt.co.kr.millielibraryandroid.util

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
import sopt.co.kr.millielibraryandroid.R

// 여러분들 나중에 앱잼할 때 칩 사용할일 있을텐데 그때 쓰세요~
fun LinearLayout.addChip(chipText: String, chipColorState: Int) {
    val chip = LayoutInflater.from(context).inflate(R.layout.view_chip, null) as Chip

    val layoutParams = ViewGroup.MarginLayoutParams(
        ViewGroup.MarginLayoutParams.WRAP_CONTENT,
        ViewGroup.MarginLayoutParams.WRAP_CONTENT
    )
    chip.text = chipText
    when (chipColorState) {
        1 -> {
            chip.chipBackgroundColor =
                ColorStateList.valueOf(ContextCompat.getColor(context, R.color.chip1_color))
        }
        2 -> {
            chip.chipBackgroundColor =
                ColorStateList.valueOf(ContextCompat.getColor(context, R.color.chip2_color))
        }
        3 -> {
            chip.chipBackgroundColor =
                ColorStateList.valueOf(ContextCompat.getColor(context, R.color.chip3_color))
        }
        4 -> {
            chip.chipBackgroundColor =
                ColorStateList.valueOf(ContextCompat.getColor(context, R.color.chip4_color))
        }
        5 -> {
            chip.chipBackgroundColor =
                ColorStateList.valueOf(ContextCompat.getColor(context, R.color.chip5_color))
        }
        6 -> {
            chip.chipBackgroundColor =
                ColorStateList.valueOf(ContextCompat.getColor(context, R.color.chip6_color))
        }
        else -> {
            chip.chipBackgroundColor = ColorStateList.valueOf(Color.LTGRAY)
        }
    }
    layoutParams.rightMargin = context.dpToPixel(4)
    addView(chip)
}