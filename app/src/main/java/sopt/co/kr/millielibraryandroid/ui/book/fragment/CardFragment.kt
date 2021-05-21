package sopt.co.kr.millielibraryandroid.ui.book.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import sopt.co.kr.millielibraryandroid.R
import sopt.co.kr.millielibraryandroid.api.data.CardInfo
import sopt.co.kr.millielibraryandroid.databinding.FragmentCardBinding
import sopt.co.kr.millielibraryandroid.ui.book.adapter.CardAdapter

class CardFragment : Fragment(){
    private var _binding: FragmentCardBinding? = null
    private val binding get() = _binding ?: error("View를 참조하기 위해 binding이 초기화되지 않았습니다.")


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentCardBinding.inflate(
            inflater,container,false
        )
        return binding.root


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




}