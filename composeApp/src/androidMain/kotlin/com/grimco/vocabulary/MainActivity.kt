package com.grimco.vocabulary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.grimco.vocabulary.data.sources.local.Factory
import com.grimco.vocabulary.data.sources.local.entities.Word
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.UUID

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        lifecycleScope.launch(Dispatchers.IO) {
            val wordsDao = Factory(application).createRoomDatabase().wordsDao()
            wordsDao.insertWord(Word(1, UUID.randomUUID().toString() ))
            val words = wordsDao.getWords()

            println(words)
        }

        setContent {
            App()
        }
    }
}

