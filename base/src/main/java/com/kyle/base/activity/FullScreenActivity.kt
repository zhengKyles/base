package com.kyle.base.activity

import android.os.Bundle
import android.view.Window
import android.view.WindowManager

import androidx.databinding.ViewDataBinding

abstract class FullScreenActivity<D : ViewDataBinding> : DataBindingActivity<D>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
    }
}
