package com.multidebugger.internal.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.multidebugger.internal.data.AppRepository
import com.multidebugger.internal.data.entity.DebugMessage

internal class DebugDashboardViewModel(application: Application) : AndroidViewModel(application) {

    fun getDebugCategories(): LiveData<List<String>> {
        return AppRepository.getDebugCategories()
    }

    fun insertDebugMessage(debugMessage: DebugMessage) {
        AppRepository.insertDebugMessage(debugMessage)
    }
}