package com.grimco.vocabulary.data.sources.local

import android.app.Application
import androidx.room.Room
import kotlinx.coroutines.Dispatchers

actual class Factory(private val app: Application) {
    actual fun createRoomDatabase(): AppDatabase {
        val dbFile = app.getDatabasePath(dbFile)
        return Room.databaseBuilder<AppDatabase>(
            context = app,
            name = dbFile.absolutePath,
        )
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }

}