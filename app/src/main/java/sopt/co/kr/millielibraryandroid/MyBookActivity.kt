package sopt.co.kr.millielibraryandroid

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import sopt.co.kr.millielibraryandroid.databinding.ActivityMybookBinding
import sopt.co.kr.millielibraryandroid.ui.note.fragment.CardFragment

class MyBookActivity : AppCompatActivity() {
    lateinit var binding: ActivityMybookBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMybookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar
        binding.toolbar.apply{
            setSupportActionBar(toolbar)
            supportActionBar?.setHomeAsUpIndicator(R.drawable.property_1_book_back_active)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        val cardFragment = CardFragment()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_container,cardFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when(id) {
            android.R.id.home -> {
                val intent = Intent(this@MyBookActivity, MainActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}