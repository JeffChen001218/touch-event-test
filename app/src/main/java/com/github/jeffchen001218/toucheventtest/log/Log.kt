package com.github.jeffchen001218.toucheventtest.log

import android.util.Log
import android.view.View
import com.github.jeffchen001218.toucheventtest.tool.getMethodName

fun logd(tag: String, msg: String) = Log.d(tag, msg)
fun loge(tag: String, msg: String) = Log.e(tag, msg)

fun logd(msg: String) = Log.d("", msg)
fun loge(msg: String) = Log.e("", msg)

fun View.logTouchCallMethod() {
    val contentDescription = contentDescription ?: "???"
    val className = this::class.java.simpleName
    val methodName = getMethodName(1)
    Log.d("触摸调用链", "${contentDescription}(${className}) - ${methodName} called")
}