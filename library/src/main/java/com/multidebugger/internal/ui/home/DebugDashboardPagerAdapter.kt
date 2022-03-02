package com.multidebuggertool.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.multidebugger.internal.ui.category_list.CategoryListFragment


internal class DebugDashboardPagerAdapter(
    private val categoryList: ArrayList<String>,
    fragmentManger: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManger, lifecycle) {

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun createFragment(position: Int): Fragment {
        val bundle = Bundle()
        bundle.putString("CATEGORY_NAME", categoryList[position])
        return CategoryListFragment.newInstance(bundle)
    }
}