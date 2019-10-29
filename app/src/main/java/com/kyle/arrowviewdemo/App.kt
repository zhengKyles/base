package com.kyle.arrowviewdemo

import android.app.Application
import android.os.Bundle
import com.kyle.base.activity.BaseActivity
import com.kyle.base.activity.OnActivityStateChangedListener

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        BaseActivity.setOnActivityStateChangedListener(object :OnActivityStateChangedListener{
            override fun onDestroy(activity: BaseActivity) {
            }

            override fun onCreate(activity: BaseActivity, savedInstanceState: Bundle?) {
            }

            override fun onStart(activity: BaseActivity) {
            }

            override fun onResume(activity: BaseActivity) {
            }

            override fun onPause(activity: BaseActivity) {
            }

            override fun onStop(activity: BaseActivity) {
            }

            override fun onRestart(activity: BaseActivity) {
            }

        })
    }
}