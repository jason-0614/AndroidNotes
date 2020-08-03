package com.android.notes.common.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * Androidx
 *
 * ViewPager2 + FragmentStateAdapter + Fragment 实现懒加载
 */
open class LazyFragmentStateAdapter(
    activity: FragmentActivity,
    private val fragments: MutableList<Fragment>
) : FragmentStateAdapter(activity) {
    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int) = fragments[position]
}