package com.kyle.base

import android.app.Activity


import java.util.Stack

/**
 * 应用程序Activity管理类
 */
class ActivityManager private constructor() {

    private val activityStack: Stack<Activity>

    init {
        activityStack = Stack()
    }

    /**
     * 添加Activity到堆栈
     */
    fun addActivity(activity: Activity) {
        activityStack.add(activity)
    }
    fun getAllActivity():Stack<Activity>{
        return activityStack
    }

    /**
     * 结束指定的Activity
     */
    fun finishActivity(activity: Activity?) {
        if (activity != null) {
            activityStack.remove(activity)
            activity.finish()
        }
    }

    /**
     * 结束指定类名的Activity
     */
    fun finishActivity(cls: Class<*>) {
        var size = activityStack.size
        var activity: Activity
        var i = 0
        while (i < size) {
            activity = activityStack[i]
            if (activity.javaClass == cls) {
                finishActivity(activity)
                i--
                size--
            }
            i++
        }
    }

    /**
     * 结束所有Activity
     */
    fun finishAllActivity() {
        var i = 0
        val size = activityStack.size
        while (i < size) {
            if (null != activityStack[i]) {
                activityStack[i].finish()
            }
            i++
        }
        activityStack.clear()
    }

    /**
     * 返回栈中指定类型的Activity，null则表示栈中不存在
     */
    fun getActivity(cls: Class<*>): Activity? {
        for (activity in activityStack) {
            if (activity.javaClass == cls) {
                return activity
            }
        }
        return null
    }

    companion object {

        private var instance: ActivityManager? = null

        /**
         * 单一实例
         */
        fun getInstance(): ActivityManager {
            if (instance == null) {
                instance = ActivityManager()
            }
            return instance as ActivityManager
        }
    }

}
