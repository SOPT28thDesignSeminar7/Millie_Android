package sopt.co.kr.millielibraryandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sopt.co.kr.millielibraryandroid.databinding.ActivityMainBinding
import sopt.co.kr.millielibraryandroid.ui.book.fragment.BookFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.main_fragment_container_view,BookFragment()).commitNow()
    }
}