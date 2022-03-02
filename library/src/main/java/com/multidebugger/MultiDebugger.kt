package com.multidebugger

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.multidebugger.internal.data.AppRepository
import com.multidebugger.internal.data.entity.DebugMessage
import com.multidebugger.internal.helper.AppSingleton
import com.multidebugger.internal.helper.NotificationHelper
import com.multidebugger.internal.ui.home.DebugDashboardActivity
import com.multidebugger.library.R

object MultiDebugger {

    private const val DEBUGGER_CHANNEL_ID = "debugger_channel"
    private const val DEBUGGER_NOTIFICATION_ID = 1001

    private val notificationManager by lazy {
        AppSingleton.getApplication()
            .getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    fun init(baseApp: Application) {
        AppSingleton.init(baseApp)
    }

    fun pushData(categoryName: String, debugMessage: DebugMessage) {
        AppRepository.insertDebugMessage(debugMessage)
        val application = AppSingleton.getApplication()

        val builder: NotificationCompat.Builder = NotificationCompat.Builder(
            application,
            DEBUGGER_CHANNEL_ID
        ).setContentIntent(
            PendingIntent.getActivity(
                application, 0, Intent(
                    application,
                    DebugDashboardActivity::class.java
                ).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK),PendingIntent.FLAG_IMMUTABLE
            )
        )
            .setLocalOnly(true)
            .setContentText(debugMessage.title)
            .setSmallIcon(R.drawable.chuck_ic_notification_white_24dp)
            .setColor(ContextCompat.getColor(application, R.color.colorPrimary))
            .setContentTitle(application.getString(R.string.notification_name))
            .setAutoCancel(true)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(
                NotificationChannel(
                    DEBUGGER_CHANNEL_ID,
                    application.getString(R.string.notification_category),
                    NotificationManager.IMPORTANCE_LOW
                )
            )
        }
        notificationManager.notify(DEBUGGER_NOTIFICATION_ID, builder.build())
    }
}