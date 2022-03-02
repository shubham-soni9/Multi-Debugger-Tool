package com.multidebuggertool

import android.app.Application
import android.content.Context

class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        application = this
    }

    companion object {
        private var application: Application? = null

        fun getApp(): Context {
            return application?.applicationContext!!
        }
    }
}