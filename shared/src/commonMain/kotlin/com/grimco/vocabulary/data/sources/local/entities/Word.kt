package com.grimco.vocabulary.data.sources.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "words")
data class Word(
    @PrimaryKey
    val id: Long,
    val name: String
)
