package com.multidebuggertool

import android.app.Application
import com.multidebugger.MultiDebugger

class BaseApp:Application() {

    override fun onCreate() {
        super.onCreate()
        MultiDebugger.init(this)
    }
}