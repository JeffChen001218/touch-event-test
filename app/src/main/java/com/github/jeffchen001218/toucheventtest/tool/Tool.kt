package com.github.jeffchen001218.toucheventtest.tool

fun getMethodName(index: Int = 0): String {
    // 经测试，再偏移3层，才是getMethodName调用处函数的真实堆栈索引
    val biasIndex = 3
    val realIndex = index + biasIndex
    // 获取当前线程的堆栈跟踪元素
    val stackTrace = Thread.currentThread().stackTrace

    // 堆栈跟踪的索引2通常是当前函数的调用者（索引0是getStackTrace，索引1是getCallerFunctionName）
    if (stackTrace.size > realIndex) {
        // 注意：根据堆栈跟踪的深度，索引可能会有所不同。调整索引以获取确切的调用者。
        return stackTrace[realIndex].methodName
    }

    return "???"
}