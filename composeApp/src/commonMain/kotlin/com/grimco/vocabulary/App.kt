package com.grimco.vocabulary

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.grimco.vocabulary.presentation.ui.screens.VocabularyScreen
import com.grimco.vocabulary.presentation.viewmodels.WordsViewModel
import kotlinx.serialization.Serializable
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(viewModel: WordsViewModel) {
    MaterialTheme {
        val navController = rememberNavController()

        NavHost(navController = navController,  startDestination = Vocabulary) {
            composable<Vocabulary> {
                VocabularyScreen(viewModel = viewModel)
            }
            composable<Grammar> {  }

        }
    }
}

@Serializable
object Vocabulary

@Serializable
object Grammar
