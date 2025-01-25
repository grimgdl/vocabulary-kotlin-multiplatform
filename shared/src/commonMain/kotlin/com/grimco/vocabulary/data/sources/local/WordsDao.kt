package com.grimco.vocabulary.data.sources.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.grimco.vocabulary.data.sources.local.entities.Word
import kotlinx.coroutines.flow.Flow


@Dao
interface WordsDao {
    @Query("select * from words")
    fun getAllWords(): Flow<List<Word>>

    @Query("select * from words")
    suspend fun getWords(): List<Word>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(word: Word)
}