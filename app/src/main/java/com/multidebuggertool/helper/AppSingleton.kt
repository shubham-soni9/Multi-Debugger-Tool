package com.multidebuggertool.helper

import androidx.room.Room
import com.multidebuggertool.BaseApp
import com.multidebuggertool.data.DebugDatabase

object AppSingleton {

    private var debugDatabase: DebugDatabase? = null
    val appExecutors: AppExecutors by lazy { AppExecutors() }

    fun getDatabase(): DebugDatabase {
        if (debugDatabase == null) {
            debugDatabase = Room.databaseBuilder(
                BaseApp.getApp(),
                DebugDatabase::class.java,
                "debug_db"
            ).build()
        }

        return debugDatabase!!
    }
}