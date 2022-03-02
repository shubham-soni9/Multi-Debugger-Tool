package com.multidebuggertool.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.multidebugger.internal.data.DebugDao
import com.multidebugger.internal.data.entity.DebugMessage

@Database(
    entities = [DebugMessage::class],
    version = 1
)
internal abstract class DebugDatabase:RoomDatabase() {

    abstract val debugDao: DebugDao
}