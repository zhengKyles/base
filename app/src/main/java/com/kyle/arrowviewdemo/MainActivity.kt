package com.kyle.arrowviewdemo

import android.os.Bundle
import com.kyle.arrowviewdemo.databinding.ActivityMainBinding
import com.kyle.base.activity.ToolBarActivity

class MainActivity : ToolBarActivity<ActivityMainBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_main

    override fun initView() {
    }

    override fun loadData() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
