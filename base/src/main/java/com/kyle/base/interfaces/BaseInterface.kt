package com.kyle.base.interfaces

/**
 * @author : kyle
 * e-mail : 1239878682@qq.com
 * @date : 2019/4/24 17:41
 * 看了我的代码，感动了吗?
 */
interface BaseInterface {
    /***
     * 获取子类提供的布局id
     * @return
     */
    val layoutId: Int

    /***
     * 子类实现:初始化布局，设置点击事件等
     */
    fun initView()

    /***
     * 子类实现:请求网络数据
     */
    fun loadData()
}
