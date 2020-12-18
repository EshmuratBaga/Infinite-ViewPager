package com.example.test.ui.main

import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import androidx.viewpager.widget.ViewPager
import kotlin.math.abs
import kotlin.math.max


class CustomViewPager @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null) : ViewPager(context, attrs), ViewPager.PageTransformer {
    private var MAX_SCALE = 0.0f
    private val fadeFactor = 0.5f
    private var mPageMargin = 8
    init {
        clipChildren = false
        clipToPadding = false
        overScrollMode = 2
        setPageTransformer(false, this)
        offscreenPageLimit = 3
        mPageMargin = dp2px(context.resources, 40)
        setPadding(mPageMargin, mPageMargin, mPageMargin, mPageMargin)
    }

    private fun dp2px(resource: Resources, dp: Int): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            resource.displayMetrics
        ).toInt()
    }

    override fun transformPage(page: View, position: Float) {
        var pos = position
        if (mPageMargin <= 0) return
        page.setPadding(mPageMargin / 3, mPageMargin / 3, mPageMargin / 3, mPageMargin / 3)

        if (MAX_SCALE == 0.0f && position > 0.0f && position < 1.0f) {
            MAX_SCALE = position
        }
        pos -= MAX_SCALE
        val absolutePosition = abs(position)
        if (position <= -1.0f || position >= 1.0f) {
            page.alpha = fadeFactor
        } else if (pos == 0.0f) {
            page.scaleX = 1 + MAX_SCALE
            page.scaleY = 1 + MAX_SCALE
            page.alpha = 1f
        } else {
            page.scaleX = 1 + MAX_SCALE * (1 - absolutePosition)
            page.scaleY = 1 + MAX_SCALE * (1 - absolutePosition)
            page.alpha = max(fadeFactor, 1 - absolutePosition)
        }
    }
}