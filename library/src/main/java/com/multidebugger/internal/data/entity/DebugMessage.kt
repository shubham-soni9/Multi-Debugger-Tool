package com.multidebugger.internal.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
public data class DebugMessage(

    @PrimaryKey(autoGenerate = true)
    val messageId: Int = 0,

    val categoryName: String = "DEFAULT",

    val title: String = "",

    val message: String = "",

    val timeStamp: Long = System.currentTimeMillis(),

    val jsonData: String = "",

    val statusType: Int = 0
)