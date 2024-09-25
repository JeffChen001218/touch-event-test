package com.github.jeffchen001218.toucheventtest

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.github.jeffchen001218.toucheventtest.databinding.ActivityMainBinding
import com.github.jeffchen001218.toucheventtest.page.NestedScrollActivity
import com.github.jeffchen001218.toucheventtest.page.TestTouchEventOrderActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun testTouchEventOrder(view: View) {
        startActivity(Intent(this, TestTouchEventOrderActivity::class.java))
    }

    fun testNestedScroll(view: View) {
        startActivity(Intent(this, NestedScrollActivity::class.java))
    }

}