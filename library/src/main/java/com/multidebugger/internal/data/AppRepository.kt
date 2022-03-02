package com.multidebugger.internal.data

import androidx.lifecycle.LiveData
import com.multidebugger.internal.data.entity.DebugMessage
import com.multidebugger.internal.helper.AppSingleton

internal object AppRepository {

    fun getDebugCategories(): LiveData<List<String>> {
        return AppSingleton.getDatabase().debugDao.getDebugCategories()
    }

    fun insertDebugMessage(debugMessage: DebugMessage){
        AppSingleton.appExecutors.diskIO().execute {
            AppSingleton.getDatabase().debugDao.insertDebugMessage(debugMessage)
        }
    }
}