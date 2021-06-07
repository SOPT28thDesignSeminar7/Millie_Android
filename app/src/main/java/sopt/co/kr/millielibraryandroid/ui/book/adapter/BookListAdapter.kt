package sopt.co.kr.millielibraryandroid.ui.book.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sopt.co.kr.millielibraryandroid.api.data.ResponseBookData
import sopt.co.kr.millielibraryandroid.databinding.ItemBookListBinding

class BookListAdapter : RecyclerView.Adapter<BookListAdapter.BookListViewHolder>() {

    val bookList = mutableListOf<ResponseBookData.BookInfo>()

    interface ItemClickListener {
        fun onClick(view: View, position: Int)
    }

    private lateinit var itemClickListener: ItemClickListener

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookListAdapter.BookListViewHolder {
        val binding =
            ItemBookListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookListAdapter.BookListViewHolder, position: Int) {
        holder.onBind(bookList[position])
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)

        }
    }

    override fun getItemCount(): Int = bookList.size

    fun setItems(newItems: List<ResponseBookData.BookInfo>) {
        bookList.clear()
        bookList.addAll(newItems)
        notifyDataSetChanged()
    }


    class BookListViewHolder(
        private val binding: ItemBookListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(bookInfo: ResponseBookData.BookInfo) {
            binding.apply {
                ivBookPoster.setImageResource(bookInfo.image)
                tvBookName.text = bookInfo.bookName
                tvBookWriter.text = bookInfo.bookWriter
                tvHighLightNumber.text = bookInfo.highLightNumber
                tvBookContent.text = bookInfo.bookContent
                tvBookDate.text = bookInfo.bookDate
            }
        }
    }
}