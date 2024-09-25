package com.github.jeffchen001218.toucheventtest.page

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.github.jeffchen001218.toucheventtest.R
import com.github.jeffchen001218.toucheventtest.databinding.ActivityNestedScrollBinding
import com.github.jeffchen001218.toucheventtest.log.logd

class NestedScrollActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNestedScrollBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_nested_scroll)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.outerScrollView)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setCustomNestedScroll()
    }

    private var innerScrollViewAtTop: Boolean? = null

    /**
     * 实现自定义嵌套滑动：先滑动外层，内部容器到顶部才能滑动内层
     */
    private fun setCustomNestedScroll() {
        // 先禁用内层容器的嵌套滑动。
        // 否则，如果最先触摸的是内层容器区域的话，
        // 在内层容器滑动到顶（或底部）之前，外层容器是收不到滚动事件的。
        // 禁用内容容器的嵌套滑动，才能让外层容器全权处理点击事件
        binding.innerScrollView.isNestedScrollingEnabled = false
        binding.outerScrollView.setOnScrollChangeListener { view, i, i2, i3, i4 ->
            val innerAtTop =
                // 内层容器滑动到顶部了
                binding.innerScrollView.top < binding.outerScrollView.scrollY
                        // 或者由于外层容器底部填充内容不够，虽然内层容器还没还没到上边缘，但已经到最顶上了
                        || !binding.outerScrollView.canScrollVertically(1)
            if (innerScrollViewAtTop == innerAtTop) {
                // 重复回调去重
                return@setOnScrollChangeListener
            }
            innerScrollViewAtTop = innerAtTop
            logd("监听内层容器位置", if (innerAtTop) "内层容器到达顶部" else "内层容器离开顶部")
            // 内层容器到达顶部后，才能嵌套滑动
            binding.innerScrollView.isNestedScrollingEnabled = innerAtTop
        }
        binding.innerScrollView.setOnScrollChangeListener { view, i, i2, i3, i4 ->
            val atTop = !binding.innerScrollView.canScrollVertically(-1)
            if (atTop) {
                binding.innerScrollView.isNestedScrollingEnabled = false
            }
        }
    }
}