package com.multidebugger.internal.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.multidebugger.internal.data.entity.DebugMessage

@Dao
internal interface DebugDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDebugMessage(debugMessage: DebugMessage)

    @Query("SELECT * FROM debugmessage WHERE categoryName = :categoryName")
    fun getDebugMessages(categoryName: String): LiveData<List<DebugMessage>>

    @Query("SELECT DISTINCT categoryName FROM debugmessage")
    fun getDebugCategories(): LiveData<List<String>>


}