package com.mylivingtrip.app.activity.filterscreen.Adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.mylivingtrip.app.activity.filterscreen.tabfrgament.FiltersFragment
import com.mylivingtrip.app.activity.filterscreen.tabfrgament.SortByragment

class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                SortByragment()
            }
            else ->return FiltersFragment()

        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Sort by"
            else ->{ "Filters"}

        }
    }
}