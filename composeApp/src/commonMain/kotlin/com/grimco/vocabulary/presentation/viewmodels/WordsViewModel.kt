package com.grimco.vocabulary.presentation.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class WordsViewModel: ViewModel() {

    private val _words = MutableStateFlow<List<String>>(emptyList())
    val words = _words.asStateFlow()


    init {
        _words.value = listOf("hola 1", "hola 2", "hola 3", "hola 4")
    }


    fun removeItem(item: String) {
        _words.value -= item
    }


    fun addItem(item: String) {
        _words.value += item
    }

}