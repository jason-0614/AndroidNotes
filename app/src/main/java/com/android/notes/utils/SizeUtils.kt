package com.android.notes.utils

import android.content.res.Resources

/**
 * 尺寸转换
 */
object SizeUtils {

    fun dp2px(dp: Float) = (dp * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

    fun px2dp(px: Float) = (px / Resources.getSystem().displayMetrics.density + 0.5f).toInt()

    fun sp2px(sp: Float) = (sp * Resources.getSystem().displayMetrics.scaledDensity + 0.5f).toInt()

    fun px2sp(px: Float) = (px / Resources.getSystem().displayMetrics.scaledDensity + 0.5f).toInt()
}