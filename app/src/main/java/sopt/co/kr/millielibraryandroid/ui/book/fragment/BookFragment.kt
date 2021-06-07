package sopt.co.kr.millielibraryandroid.ui.book.fragment

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import sopt.co.kr.millielibraryandroid.R
import sopt.co.kr.millielibraryandroid.api.ServiceCreator
import sopt.co.kr.millielibraryandroid.api.data.BookInfo
import sopt.co.kr.millielibraryandroid.databinding.FragmentBookBinding
import sopt.co.kr.millielibraryandroid.ui.book.CustomDecoration
import sopt.co.kr.millielibraryandroid.ui.book.adapter.BookListAdapter
import sopt.co.kr.millielibraryandroid.ui.note.fragment.NoteFragment
import sopt.co.kr.millielibraryandroid.util.enqueueUtil

class BookFragment : Fragment() {

    private lateinit var binding: FragmentBookBinding
    private val bookListAdapter = BookListAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBookBinding.inflate(inflater, container, false)
        binding.bookTab.apply {
            addTab(this.newTab().setText("내책장"))
            addTab(this.newTab().setText("독서노트"))
            addTab(this.newTab().setText("통계"))
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bookRecyclerList.adapter = bookListAdapter
        binding.bookRecyclerList.addItemDecoration(CustomDecoration(1f, 10f, Color.LTGRAY))

        addBookList()
        bookListClickEvent()

    }

    private fun addBookList() {
        val call = ServiceCreator.milliService.getBookList()

        call.enqueueUtil(
            onSuccess = {
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
                bundle.putString("bookName", bookListAdapter.bookList[position].bookName)
                bundle.putString("image", bookListAdapter.bookList[position].image)
                bundle.putString("bookCount", bookListAdapter.bookList[position].hightlights[0].highlightText)
                bundle.putString("bookDate", bookListAdapter.bookList[position].hightlights[0].highlightDate)
                val noteFragment = NoteFragment()
                noteFragment.arguments = bundle
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.main_fragment_container_view, noteFragment).commitNow()
            }
        })
    }
}