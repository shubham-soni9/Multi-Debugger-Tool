package com.multidebuggertool.ui.category_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.multidebuggertool.data.entity.DebugMessage
import com.multidebuggertool.helper.AppSingleton

class CategoryListViewModel : ViewModel() {

    fun getDebugMessages(categoryName:String): LiveData<List<DebugMessage>> {
        return AppSingleton.getDatabase().debugDao.getDebugMessages(categoryName)
    }
}