package com.multidebugger

import android.app.Application
import com.multidebugger.internal.data.AppRepository
import com.multidebugger.internal.data.entity.DebugMessage
import com.multidebugger.internal.helper.AppSingleton
import com.multidebugger.internal.helper.NotificationHelper

object MultiDebugger {

    fun init(baseApp: Application) {
        AppSingleton.init(baseApp)
    }

    fun pushData(categoryName: String, debugMessage: DebugMessage) {
        AppRepository.insertDebugMessage(debugMessage)


    }
}