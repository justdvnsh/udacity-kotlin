package com.divyansh.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.divyansh.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Divyansh Dwivedi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.doneBtn.setOnClickListener {
            addNickname()
        }
    }

    private fun addNickname() {
        binding.apply {
            val nickNameString = nickname.text.toString()
            binding.myName?.nickname = nickNameString
            invalidateAll()
            nickname.visibility = GONE
            doneBtn.visibility = GONE
            nicknameText.visibility = VISIBLE
        }

        // hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.doneBtn.windowToken, 0)
    }


}
