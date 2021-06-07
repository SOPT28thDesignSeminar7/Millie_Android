package sopt.co.kr.millielibraryandroid.ui.book.fragment

import android.graphics.Color
import android.os.Bundle
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
                bookListAdapter.setItems(it)
            }
        )
//        bookListAdapter.setItems(
//            listOf<BookInfo>(
//                BookInfo(
//                    image = R.drawable.img_book_1,
//                    bookName = "넛지",
//                    bookWriter = "리처드 H.탈러",
//                    highLightNumber = "2",
//                    bookContent = "디폴트 옵션이 존재하지 않는다.",
//                    bookDate = "2021.03.09"
//                ),
//                BookInfo(
//                    image = R.drawable.img_book_2,
//                    bookName = "달러구트 꿈 백화점",
//                    bookWriter = "이미예",
//                    highLightNumber = "6",
//                    bookContent = "숨 가쁘게 이어지는 직선 같은 삶에 신께서 공들여 그려 넣은 쉼표인 것 같아요!",
//                    bookDate = "2021.02.05"
//                ),
//                BookInfo(
//                    image = R.drawable.img_book_3,
//                    bookName = "그림책으로 읽는 감정 수업",
//                    bookWriter = "송귀예",
//                    highLightNumber = "1",
//                    bookContent = "불안함은 불확실성에서 오는 경우가 많은데, 자신의 감정이 무엇인지 알게 되면 그 불확실성이 감소하기 때문입니다.",
//                    bookDate = "2021.02.04"
//                ),
//                BookInfo(
//                    image = R.drawable.img_book_4,
//                    bookName = "오래 준비해온 대답",
//                    bookWriter = "김영하",
//                    highLightNumber = "4",
//                    bookContent = "사서 축적하는 삶이 아니라 모든게 왔다가 그대로 가도록 하는 삶",
//                    bookDate = "2021.01.07"
//                )
//            )
//        )
        bookListAdapter.notifyDataSetChanged()
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
                bundle.putInt("image", bookListAdapter.bookList[position].image)
                bundle.putString("bookCount", bookListAdapter.bookList[position].bookContent)
                bundle.putString("bookDate", bookListAdapter.bookList[position].bookDate)
                val noteFragment = NoteFragment()
                noteFragment.arguments = bundle
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.main_fragment_container_view, noteFragment).commitNow()
            }
        })
    }
}