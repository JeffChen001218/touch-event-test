package com.github.jeffchen001218.toucheventtest.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.FrameLayout
import com.github.jeffchen001218.toucheventtest.log.logTouchCallMethod

/**
 * @Date 2024/9/24-14:58
 * @Desc
 */
class BaseFrameLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
) : FrameLayout(context, attrs, defStyleAttr, defStyleRes){

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        logTouchCallMethod()
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        logTouchCallMethod()
        return super.onInterceptTouchEvent(ev)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        logTouchCallMethod()
        return super.onTouchEvent(event)
    }

}