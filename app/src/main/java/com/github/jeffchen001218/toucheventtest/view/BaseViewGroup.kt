package com.github.jeffchen001218.toucheventtest.view

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup

/**
 * @Date 2024/9/24-14:58
 * @Desc
 */
abstract class BaseViewGroup @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
) : ViewGroup(context, attrs, defStyleAttr, defStyleRes)