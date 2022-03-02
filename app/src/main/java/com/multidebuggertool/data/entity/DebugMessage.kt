package com.multidebuggertool.data.entity

import android.icu.text.CaseMap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DebugMessage(

    @PrimaryKey(autoGenerate = true)
    val messageId: Int = 0,

    val categoryName: String = "DEFAULT",

    val title: String = "",

    val message: String = "",

    val timeStamp: Long = System.currentTimeMillis(),

    val jsonData: String = "",

    val statusType: Int = 0
)