package com.grimco.vocabulary.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grimco.vocabulary.data.sources.local.WordsDao
import com.grimco.vocabulary.data.sources.local.entities.WordEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class WordsViewModel(private val wordsDao: WordsDao): ViewModel() {

    private val _words = wordsDao.getAllWords()

    val words = _words.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    fun removeItem(word: WordEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            wordsDao.delete(word)
        }

    }

    fun addItem(word: WordEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            wordsDao.insertWord(word)
        }
    }

}