package sopt.co.kr.millielibraryandroid.ui.note.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import sopt.co.kr.millielibraryandroid.R
import sopt.co.kr.millielibraryandroid.api.data.CardInfo
import sopt.co.kr.millielibraryandroid.databinding.FragmentNoteBinding
import sopt.co.kr.millielibraryandroid.ui.book.adapter.CardAdapter
import sopt.co.kr.millielibraryandroid.ui.book.fragment.BookFragment

class NoteFragment : Fragment() {

    private lateinit var binding: FragmentNoteBinding

    private lateinit var cardAdapter: CardAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bookName = arguments?.getString("bookName")
        val bookDate = arguments?.getString("bookDate")
        Log.d("test", "$bookName $bookDate")
        setAdapter()

        arguments?.getInt("image")?.let { binding.ivBook.setImageResource(it) }
        binding.tvBookTool.text = bookName

        val bookFragment = BookFragment()
        binding.noteToolbar.apply {
            setNavigationIcon(R.drawable.property_1_book_back_active)
            setNavigationOnClickListener{
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.main_fragment_container_view, bookFragment).commitNow()
            }
            // todo : 예진 파트
            // 나중에 하고 여기 툴바 작업해야죠
            // 인터넷에 tool bar fragment
            // 앱잼해야되잖아 아니야?
            // 구조잡는법을 많이 해보는게 좋을거같아요!!
        }
    }

    private fun setAdapter() {
        cardAdapter = CardAdapter()

        binding.noteCardList.adapter = cardAdapter

        cardAdapter.cardList.addAll(
            listOf<CardInfo>(
                CardInfo(
                    cardImage = R.drawable.and_mybook_card
                ),
                CardInfo(
                    cardImage = R.drawable.and_mybook_card
                ),
                CardInfo(
                    cardImage = R.drawable.and_mybook_card
                ),
                CardInfo(
                    cardImage = R.drawable.and_mybook_card
                ),
                CardInfo(
                    cardImage = R.drawable.and_mybook_card
                ),
                CardInfo(
                    cardImage = R.drawable.and_mybook_card
                )
            )
        )
        cardAdapter.notifyDataSetChanged()

    }
}