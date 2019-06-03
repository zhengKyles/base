package com.kyle.base.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @author : kyle
 * e-mail : 1239878682@qq.com
 * @date : 2019/4/24 17:23
 * 看了我的代码，感动了吗?
 */
open class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState?.let { listener.onCreate(this, it) }
    }

    override fun onStart() {
        super.onStart()
        listener.onStart(this)
    }

    override fun onResume() {
        super.onResume()
        listener.onResume(this)
    }

    override fun onPause() {
        super.onPause()
        listener.onPause(this)
    }

    override fun onStop() {
        super.onStop()
        listener.onStop(this)
    }
    override fun onDestroy() {
        super.onDestroy()
        listener.onDestroy(this)
    }

    companion object {
        private lateinit var listener: OnActivityStateChangedListener
        fun setOnActivityStateChangedListener(listener: OnActivityStateChangedListener) {
            this.listener=listener
        }
    }
}
