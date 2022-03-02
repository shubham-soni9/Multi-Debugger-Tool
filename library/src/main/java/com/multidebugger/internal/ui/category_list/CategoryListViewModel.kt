package com.multidebugger.internal.ui.category_list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.multidebugger.internal.data.entity.DebugMessage
import com.multidebugger.internal.helper.AppSingleton

internal class CategoryListViewModel(application: Application) : AndroidViewModel(application) {

    fun getDebugMessages(categoryName: String): LiveData<List<DebugMessage>> {
        return AppSingleton.getDatabase().debugDao.getDebugMessages(categoryName)
    }
}