package com.multidebuggertool.helper

import android.app.Application
import androidx.room.Room
import com.multidebugger.internal.helper.AppExecutors
import com.multidebuggertool.data.DebugDatabase

internal object AppSingleton {

    private var debugDatabase: DebugDatabase? = null
    val appExecutors: AppExecutors by lazy { AppExecutors() }

    fun getDatabase(application: Application): DebugDatabase {
        if (debugDatabase == null) {
            debugDatabase = Room.databaseBuilder(
                application,
                DebugDatabase::class.java,
                "debug_db"
            ).build()
        }

        return debugDatabase!!
    }
}