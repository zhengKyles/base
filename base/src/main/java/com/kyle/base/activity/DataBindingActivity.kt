package com.kyle.base.activity

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.kyle.base.interfaces.BaseInterface

/**
 * @author : kyle
 * e-mail : 1239878682@qq.com
 * @date : 2019/4/24 17:38
 * 看了我的代码，感动了吗?
 */
abstract class DataBindingActivity<D : ViewDataBinding> : BaseActivity(), BaseInterface {
    protected lateinit var binding: D
    protected lateinit var rootView: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initContentView()
        initView()
    }

     open fun initContentView() {
        val contentView = View.inflate(this, layoutId, null)
        rootView = LinearLayout(this)
        rootView.orientation = LinearLayout.VERTICAL
        binding = DataBindingUtil.bind(contentView)!!
        rootView.addView(contentView)
        setContentView(rootView)
    }

}
