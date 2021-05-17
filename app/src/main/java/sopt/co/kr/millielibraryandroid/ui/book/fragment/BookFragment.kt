package sopt.co.kr.millielibraryandroid.ui.book.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sopt.co.kr.millielibraryandroid.R
import sopt.co.kr.millielibraryandroid.databinding.FragmentBookBinding

class BookFragment : Fragment() {

    private lateinit var binding : FragmentBookBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBookBinding.inflate(inflater,container,false)
        binding.bookTab.apply {
            addTab(this.newTab().setText("내책장"))
            addTab(this.newTab().setText("독서노트"))
            addTab(this.newTab().setText("통계"))
        }
        return binding.root
    }

}