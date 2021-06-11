package sopt.co.kr.millielibraryandroid.ui.book.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import sopt.co.kr.millielibraryandroid.R
import sopt.co.kr.millielibraryandroid.api.retrofit.ServiceCreator
import sopt.co.kr.millielibraryandroid.api.data.BookInfo
import sopt.co.kr.millielibraryandroid.databinding.FragmentBookListBinding
import sopt.co.kr.millielibraryandroid.ui.book.CustomDecoration
import sopt.co.kr.millielibraryandroid.ui.book.adapter.BookListAdapter
import sopt.co.kr.millielibraryandroid.ui.note.fragment.NoteFragment
import sopt.co.kr.millielibraryandroid.util.enqueueUtil

class BookListFragment : Fragment() {

    private lateinit var binding: FragmentBookListBinding
    private val bookListAdapter = BookListAdapter()

    // 좋은 방법 아니니까 쓰지 마세요
    val serverDataList = mutableListOf<BookInfo>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBookListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.bookRecyclerList.adapter = bookListAdapter
        binding.bookRecyclerList.addItemDecoration(CustomDecoration(1f, 10f, Color.LTGRAY))

        addBookList()
        bookListClickEvent()
    }

    private fun addBookList() {
        val call = ServiceCreator.milliService.getBookList()

        call.enqueueUtil(
            onSuccess = {
                it.data!!.books.forEach {
                    serverDataList.add(it)
                }
                bookListAdapter.setItems(it.data!!.books)
            }
        )
    }

    private fun bookListClickEvent() {
        bookListAdapter.setItemClickListener(object : BookListAdapter.ItemClickListener {
            override fun onClick(view: View, position: Int) {
                Toast.makeText(
                    requireActivity(),
                    "${bookListAdapter.bookList[position].bookName} 선택하셨습니다.",
                    Toast.LENGTH_LONG
                ).show()
                val bundle = Bundle()
                bundle.putString("dbKeyValue", serverDataList[position].id)
                bundle.putString("bookName", bookListAdapter.bookList[position].bookName)
                bundle.putString("image", bookListAdapter.bookList[position].image)
                bundle.putString(
                    "bookCount",
                    bookListAdapter.bookList[position].hightlights[0].highlightText
                )
                bundle.putString(
                    "bookDate",
                    bookListAdapter.bookList[position].hightlights[0].highlightDate
                )
                val noteFragment = NoteFragment()
                noteFragment.arguments = bundle
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.main_fragment_container_view, noteFragment).commitNow()
            }
        })
    }
}