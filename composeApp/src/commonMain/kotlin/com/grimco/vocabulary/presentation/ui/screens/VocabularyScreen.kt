package com.grimco.vocabulary.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.grimco.vocabulary.Greeting
import com.grimco.vocabulary.data.sources.local.entities.WordEntity
import com.grimco.vocabulary.presentation.ui.components.Word
import com.grimco.vocabulary.presentation.viewmodels.WordsViewModel
import java.util.UUID

@Composable
fun VocabularyScreen(
    modifier: Modifier = Modifier,
    viewModel: WordsViewModel
) {
    val greeting = remember { Greeting() }
    val list by viewModel.words.collectAsState()

    Column {
        OutlinedButton(
            onClick = {
                viewModel.addItem(WordEntity(3, UUID.randomUUID().toString()))
            }
        ) {
            Text(text = "Add")
        }
        LazyColumn {
            items(items = list, key = { it.id } ) { item ->

                Word(
                    word = item,
                    onClickWord = { word ->
                        viewModel.removeItem(word)
                    },
                    modifier = Modifier.fillParentMaxWidth()
                )

            }
        }
    }



}

