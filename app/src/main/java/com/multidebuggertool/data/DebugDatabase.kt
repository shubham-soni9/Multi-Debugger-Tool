package com.multidebuggertool.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.multidebuggertool.data.entity.DebugMessage

@Database(
    entities = [DebugMessage::class],
    version = 1
)
abstract class DebugDatabase:RoomDatabase() {

    abstract val debugDao: DebugDao
}