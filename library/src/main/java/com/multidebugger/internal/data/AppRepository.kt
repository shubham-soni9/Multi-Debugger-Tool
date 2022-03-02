package com.multidebugger.internal.data

import android.app.Application
import androidx.lifecycle.LiveData
import com.multidebugger.internal.data.entity.DebugMessage
import com.multidebuggertool.helper.AppSingleton

internal object AppRepository {

    fun getDebugCategories(application: Application): LiveData<List<String>> {
        return AppSingleton.getDatabase(application).debugDao.getDebugCategories()
    }

    fun insertDebugMessage(debugMessage: DebugMessage,application: Application){
        AppSingleton.appExecutors.diskIO().execute {
            AppSingleton.getDatabase(application).debugDao.insertDebugMessage(debugMessage)
        }
    }
}