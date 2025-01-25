package com.grimco.vocabulary.data.sources.local

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import java.io.File


actual class Factory {

    actual fun createRoomDatabase(): AppDatabase {

        val os = System.getProperty("os.name").lowercase()
        val userHome = System.getProperty("user.home")

        println("OS $os")

        val appDataDir = when {
            os.contains("win") -> File(System.getenv("APPDATA"), "Words")
            os.contains("mac") -> File(userHome, "Library/Application Support/Words")
            else -> File(userHome, ".local/share/Words")
        }

        if (! appDataDir.exists()) {
            appDataDir.mkdirs()
        }

        val dbFile = File(appDataDir, dbFile)
        return Room.databaseBuilder<AppDatabase>(
            name = dbFile.absolutePath,
        )
            .setDriver(BundledSQLiteDriver())
            .build()
    }



}