package com.grimco.vocabulary

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.grimco.vocabulary.ui.screens.VocabularyScreen
import kotlinx.serialization.Serializable
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()


        NavHost(navController = navController,  startDestination = Vocabulary) {

            composable<Vocabulary> {

                VocabularyScreen()

            }

            composable<Grammar> {  }



        }



        
    }
}

@Serializable
object Vocabulary

@Serializable
object Grammar
