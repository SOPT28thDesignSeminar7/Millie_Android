package sopt.co.kr.millielibraryandroid.ui.book.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sopt.co.kr.millielibraryandroid.api.data.CardInfo
import sopt.co.kr.millielibraryandroid.databinding.ItemMybookBinding

class CardAdapter : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {
    val cardList = mutableListOf<CardInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardAdapter.CardViewHolder {
        val binding = ItemMybookBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CardViewHolder(binding)
    }

    override fun getItemCount(): Int = cardList.size

    override fun onBindViewHolder(holder: CardAdapter.CardViewHolder, position: Int) {
        holder.onBind(cardList[position])
    }

    class CardViewHolder(
        private val binding: ItemMybookBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(cardInfo: CardInfo) {
            binding.apply {
                tvTitle.text = cardInfo.cardTitle
                tvDate.text = cardInfo.cardDate
                tvTime.text = cardInfo.cardTime
                ivBtnMore.setImageResource(cardInfo.cardBtn)
            }
        }
    }
}