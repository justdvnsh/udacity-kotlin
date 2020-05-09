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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.doneBtn.setOnClickListener {
            addNickname()
        }
    }

    private fun addNickname() {
        binding.apply {
            val nickNameString = nickname.text
            nicknameText.setText(nickNameString)
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
