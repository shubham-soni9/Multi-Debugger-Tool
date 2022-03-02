package com.multidebuggertool.data

import androidx.lifecycle.LiveData
import com.multidebuggertool.data.entity.DebugMessage
import com.multidebuggertool.helper.AppSingleton

object AppRepository {

    fun getDebugCategories(): LiveData<List<String>> {
        return AppSingleton.getDatabase().debugDao.getDebugCategories()
    }

    fun insertDebugMessage(debugMessage: DebugMessage){
        AppSingleton.appExecutors.diskIO().execute {
            AppSingleton.getDatabase().debugDao.insertDebugMessage(debugMessage)
        }
    }
}