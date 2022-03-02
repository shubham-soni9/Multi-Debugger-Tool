package com.multidebuggertool

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.multidebugger.MultiDebugger
import com.multidebugger.internal.data.entity.DebugMessage

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MultiDebugger.pushData(
            MultiDebuggerConstant.CATEGORY_DRIVER,
            DebugMessage(
                title = "Driver Reached",
                message = "Please pickup your item"
            )
        )
    }
}