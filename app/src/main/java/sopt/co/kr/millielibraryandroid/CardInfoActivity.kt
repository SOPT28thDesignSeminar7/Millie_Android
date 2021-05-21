package sopt.co.kr.millielibraryandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import sopt.co.kr.millielibraryandroid.databinding.ActivityCardInfoBinding
import sopt.co.kr.millielibraryandroid.ui.note.fragment.CardFragment

class CardInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCardInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val cardFragment = CardFragment()

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.card_info_fragment, cardFragment)
        transaction.commit()
    }
}