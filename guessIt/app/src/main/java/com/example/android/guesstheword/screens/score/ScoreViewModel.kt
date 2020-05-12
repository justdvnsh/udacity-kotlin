package com.example.android.guesstheword.screens.score

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel(var score: Int): ViewModel() {

    private val _score = MutableLiveData<String>()
    val finalScore: LiveData<String>
        get() = _score

    init {
        _score.value = score.toString()
    }
}