package sopt.co.kr.millielibraryandroid.ui.book.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sopt.co.kr.millielibraryandroid.R
import sopt.co.kr.millielibraryandroid.api.ServiceCreator
import sopt.co.kr.millielibraryandroid.api.data.HighLights
import sopt.co.kr.millielibraryandroid.api.data.ResponseNoteData
import sopt.co.kr.millielibraryandroid.databinding.FragmentNoteBinding
import sopt.co.kr.millielibraryandroid.ui.book.adapter.CardAdapter

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
        }
    }

    private fun setAdapter() {
        val call: Call<ResponseNoteData> = ServiceCreator.milliService.getNoteList(1)
        call.enqueue(object : Callback<ResponseNoteData> {
            override fun onResponse(
                call: Call<ResponseNoteData>,
                response: Response<ResponseNoteData>
            ){
                if(response.isSuccessful){
                    val data = response.body()?.data
                    cardAdapter.cardList == data.highlights
                    Log.d("success", "${data}")
                    cardAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<ResponseNoteData>, t: Throwable) {
                Log.d("NetworkTest", "error:$t")
            }
        })

    }
}