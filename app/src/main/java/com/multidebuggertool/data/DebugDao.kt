package com.multidebuggertool.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.multidebuggertool.data.entity.DebugMessage

@Dao
interface DebugDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDebugMessage(debugMessage: DebugMessage)

    @Query("SELECT * FROM debugmessage WHERE categoryName = :categoryName")
    fun getDebugMessages(categoryName: String): LiveData<List<DebugMessage>>

    @Query("SELECT DISTINCT categoryName FROM debugmessage")
    fun getDebugCategories(): LiveData<List<String>>


}