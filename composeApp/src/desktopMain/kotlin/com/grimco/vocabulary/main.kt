package com.grimco.vocabulary

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.lifecycle.viewmodel.compose.viewModel
import com.grimco.vocabulary.data.sources.local.Factory
import com.grimco.vocabulary.presentation.viewmodels.WordsViewModel


fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Vocabulary",
    ) {

        val viewModel : WordsViewModel = viewModel { WordsViewModel(Factory().createRoomDatabase().wordsDao()) }
        App(viewModel)
    }
}