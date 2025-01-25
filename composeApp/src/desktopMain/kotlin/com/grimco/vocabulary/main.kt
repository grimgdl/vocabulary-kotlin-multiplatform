package com.grimco.vocabulary

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.grimco.vocabulary.data.sources.local.Factory
import com.grimco.vocabulary.data.sources.local.entities.Word
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.UUID


fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Vocabulary",
    ) {

        CoroutineScope(Dispatchers.IO).launch {
            val dao = Factory().createRoomDatabase().wordsDao()
            dao.insertWord(Word(1, UUID.randomUUID().toString()))
        }


        App()
    }
}