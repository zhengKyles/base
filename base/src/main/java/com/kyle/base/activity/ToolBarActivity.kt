package com.kyle.base.activity

import android.graphics.Color
import android.util.TypedValue.COMPLEX_UNIT_SP
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.kyle.arrowview.DensityUtil
import com.kyle.base.R
import com.kyle.base.databinding.LayoutTitleBinding

/**
 * @author : kyle
 * e-mail : 1239878682@qq.com
 * @date : 2019/4/24 17:54
 * 看了我的代码，感动了吗?
 */
abstract class ToolBarActivity<D : ViewDataBinding> : DataBindingActivity<D>() {
    protected lateinit var titleBinding: LayoutTitleBinding
    private var mTitleBarHeight: Int = 0

    override fun initContentView() {
        super.initContentView()
        titleBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.layout_title, null, false)
        val titleView = titleBinding.root
        mTitleBarHeight = DensityUtil.dip2px(this, 50f)
        val titleParam = LinearLayout.LayoutParams(MATCH_PARENT, mTitleBarHeight)
        titleView.layoutParams = titleParam
        rootView.addView(titleView, 0)
        titleBinding.rlBack.setOnClickListener {
            onBackPressed()
        }
    }

    protected fun setTitle(title: String) {
        titleBinding.tvTitle.text = title
    }

    protected fun setSubTitle(subTitle: String) {
        titleBinding.tvSubTitle.text = subTitle
        titleBinding.tvSubTitle.visibility = View.VISIBLE
    }

    protected fun addRightBtn(view: ImageView, onClickListener: View.OnClickListener) {
        val param = LinearLayout.LayoutParams(DensityUtil.dip2px(this, 20f), DensityUtil.dip2px(this, 20f))
        titleBinding.llRight.addView(view, param)
        view.setOnClickListener(onClickListener)
    }

    protected fun addRightBtn(view: TextView, onClickListener: View.OnClickListener) {
        val param = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        titleBinding.llRight.addView(view, param)
        view.setOnClickListener(onClickListener)
    }

}
