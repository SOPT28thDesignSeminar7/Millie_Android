package sopt.co.kr.millielibraryandroid.ui.book.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sopt.co.kr.millielibraryandroid.api.data.HighLights
import sopt.co.kr.millielibraryandroid.databinding.ItemMybookBinding

// 얘가 보여주려고 하는게 CardInfo가 아니죠
// HighLights 보여주는 친구잖아?
class CardAdapter : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {
    val cardList = mutableListOf<HighLights>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardAdapter.CardViewHolder {
        val binding = ItemMybookBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CardViewHolder(binding)
    }

    override fun getItemCount(): Int = cardList.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.onBind(cardList[position])
    }

    class CardViewHolder(
        private val binding: ItemMybookBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(cardHighLight: HighLights) {
            binding.apply {
                tvTitle.text = cardHighLight.highlightText
                tvDate.text = cardHighLight.highlightDate
            }
        }
    }

    // RecyclerView를 좀 더 보고 이해하기를 권장합니다.
    fun submitItem(items: List<HighLights>) {
        cardList.clear() // 기존 리스트의 아이템을 지운후
        cardList.addAll(items) // 서버로 부터 받은 데이터를 꽂음
        notifyDataSetChanged() // NotifyDataSetChanged
    }
}