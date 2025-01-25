package com.grimco.vocabulary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.grimco.vocabulary.data.sources.local.Factory
import com.grimco.vocabulary.presentation.viewmodels.WordsViewModel

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val wordsViewModel: WordsViewModel = viewModel { WordsViewModel(Factory(application).createRoomDatabase().wordsDao()) }
            App(viewModel = wordsViewModel)
        }
    }
}

