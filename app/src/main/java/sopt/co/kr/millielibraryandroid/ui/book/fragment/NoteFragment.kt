package sopt.co.kr.millielibraryandroid.ui.book.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sopt.co.kr.millielibraryandroid.R
import sopt.co.kr.millielibraryandroid.api.ServiceCreator
import sopt.co.kr.millielibraryandroid.api.data.ResponseNoteData
import sopt.co.kr.millielibraryandroid.databinding.FragmentNoteBinding
import sopt.co.kr.millielibraryandroid.ui.book.adapter.CardAdapter
import sopt.co.kr.millielibraryandroid.util.addChip
import sopt.co.kr.millielibraryandroid.util.dpToPixel

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
        cardAdapter = CardAdapter()
        binding.noteCardList.adapter = cardAdapter

        arguments?.getInt("image")?.let { binding.ivBook.setImageResource(it) }
        binding.tvBookTool.text = bookName

        val bookFragment = BookFragment()
        binding.noteToolbar.apply {
            setNavigationIcon(R.drawable.property_1_book_back_active)
            setNavigationOnClickListener {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.main_fragment_container_view, bookFragment).commitNow()
            }
        }

        binding.chipGroup.apply {
            addChip("전체", 0)
            addChip("  ", 1)
            addChip("  ", 2)
            addChip("  ", 3)
            addChip("  ", 4)
            addChip("  ", 5)
            addChip("  ", 6)
        }

        ServiceCreator.milliService.getNoteList(arguments?.getString("dbKeyValue")!!)
            .enqueue(object : Callback<ResponseNoteData> {
                override fun onResponse(
                    call: Call<ResponseNoteData>,
                    response: Response<ResponseNoteData>
                ) {
                    // 서버와 데이터 통신이 성공한 경우
                    if (response.isSuccessful) {
                        response.body()?.data?.let { resData ->
                            binding.apply {
                                tvBookTool.text = resData.cardTitle
                                tvNum.text = resData.highLightNumber.toString()
                                Glide.with(ivBook)
                                    .load(resData.image)
                                    .override(
                                        requireContext().dpToPixel(200),
                                        requireContext().dpToPixel(300)
                                    )
                                    .into(ivBook)
                                cardAdapter.apply {
                                    submitItem(resData.highlights)
                                }
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseNoteData>, t: Throwable) {
                    // 서버와 데이터 통신이 실패한 경우
                }

            })
    }
}