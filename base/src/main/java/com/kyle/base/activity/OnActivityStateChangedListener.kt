package com.kyle.base.activity

import android.os.Bundle

/**
 *    @author : kyle
 *    e-mail : 1239878682@qq.com
 *    @date   : 2019/5/22 16:50
 *    看了我的代码，感动了吗?
 */
interface OnActivityStateChangedListener {
    fun onDestroy(activity: BaseActivity)
    fun onCreate(activity: BaseActivity,savedInstanceState: Bundle?)
    fun onStart(activity: BaseActivity)
    fun onResume(activity: BaseActivity)
    fun onPause(activity: BaseActivity)
    fun onStop(activity: BaseActivity)
    fun onRestart(activity: BaseActivity)
}