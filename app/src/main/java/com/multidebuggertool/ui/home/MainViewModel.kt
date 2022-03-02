package com.multidebuggertool.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.multidebuggertool.data.AppRepository
import com.multidebuggertool.data.DebugDatabase
import com.multidebuggertool.data.entity.DebugMessage

class MainViewModel : ViewModel() {

    fun getDebugCategories(): LiveData<List<String>> {
        return AppRepository.getDebugCategories()
    }

    fun insertDebugMessage(debugMessage: DebugMessage) {
        AppRepository.insertDebugMessage(debugMessage)
    }
}