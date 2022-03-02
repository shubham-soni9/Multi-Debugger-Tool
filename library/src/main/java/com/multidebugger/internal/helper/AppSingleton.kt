package com.multidebugger.internal.helper

import android.annotation.SuppressLint
import android.app.Application
import androidx.room.Room
import com.multidebuggertool.data.DebugDatabase

internal object AppSingleton {
    @SuppressLint("StaticFieldLeak")
    private var mApplication: Application? = null

    fun init(application: Application) {
        this.mApplication = application
    }

    fun getApplication(): Application {
        return mApplication!!
    }

    private var debugDatabase: DebugDatabase? = null
    val appExecutors: AppExecutors by lazy { AppExecutors() }


    fun getDatabase(): DebugDatabase {
        if (debugDatabase == null) {
            debugDatabase = Room.databaseBuilder(
                getApplication(),
                DebugDatabase::class.java,
                "debug_db"
            ).build()
        }

        return debugDatabase!!
    }
}