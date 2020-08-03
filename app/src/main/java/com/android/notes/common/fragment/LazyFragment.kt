package com.android.notes.common.fragment

import androidx.fragment.app.Fragment

/**
 * Androidx
 *
 * ViewPager2 + FragmentStateAdapter + Fragment 实现懒加载
 */
abstract class LazyFragment : Fragment() {

    private var isLoaded = false

    override fun onResume() {
        super.onResume()
        if (!isLoaded && !isHidden) {
            lazyInit()
            isLoaded = true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        isLoaded = false
    }

    abstract fun lazyInit()
}