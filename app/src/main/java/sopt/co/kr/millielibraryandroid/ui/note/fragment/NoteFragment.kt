package sopt.co.kr.millielibraryandroid.ui.note.fragment

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sopt.co.kr.millielibraryandroid.databinding.FragmentNoteBinding

class NoteFragment : Fragment() {

    private lateinit var binding : FragmentNoteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bookName = arguments?.getString("bookName")
        val bookDate = arguments?.getString("bookDate")
        Log.d("test", "$bookName $bookDate")

    }
}