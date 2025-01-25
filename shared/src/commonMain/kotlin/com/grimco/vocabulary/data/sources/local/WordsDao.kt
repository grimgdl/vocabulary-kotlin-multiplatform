package com.grimco.vocabulary.data.sources.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.grimco.vocabulary.data.sources.local.entities.WordEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface WordsDao {
    @Query("select * from words")
    fun getAllWords(): Flow<List<WordEntity>>

    @Query("select * from words")
    suspend fun getWords(): List<WordEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(word: WordEntity)

    @Delete
    suspend fun delete(word: WordEntity)
}