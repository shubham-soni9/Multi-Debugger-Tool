package com.multidebugger.internal.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.multidebugger.library.R
import com.multidebuggertool.ui.home.DebugDashboardPagerAdapter

internal class DebugDashboardActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProvider(this)[DebugDashboardViewModel::class.java]
    }
    private val preCategoryList: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val categoryViewPager = findViewById<ViewPager2>(R.id.categoryPager)
        viewModel.getDebugCategories().observe(this, Observer { newCategoryList ->
            if (!isListEqual(preCategoryList, newCategoryList)) {
                preCategoryList.clear()
                preCategoryList.addAll(newCategoryList)
                val pagerAdapter = DebugDashboardPagerAdapter(
                    categoryList = preCategoryList,
                    fragmentManger = supportFragmentManager,
                    lifecycle = lifecycle
                )
                val tabLayout = findViewById<TabLayout>(R.id.tabCategory)
                tabLayout.removeAllTabs()
                for (category in preCategoryList) {
                    tabLayout.addTab(tabLayout.newTab().setText(category))
                }
                categoryViewPager.adapter = pagerAdapter

                TabLayoutMediator(tabLayout, categoryViewPager) { tab, position ->
                    tab.text = preCategoryList[position]
                }.attach()
                tabLayout.tabMode = TabLayout.MODE_SCROLLABLE
            }
        })
    }

    private fun isListEqual(list1: List<String>, list2: List<String>): Boolean {
        try {
            if (list1.size != list2.size) return false
            for (itemIndices in list1.indices) {
                if (list1[itemIndices] != list2[itemIndices]) {
                    return false
                }
            }
            return true
        } catch (e: Exception) {
            return false
        }
    }
}