package com.kyle.base.activity

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
        titleBinding =
            DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.layout_title, null, false)
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

    protected fun addRightBtn(intRes: Int, onClickListener: View.OnClickListener) {
        val imageView = ImageView(this)
        imageView.setImageResource(intRes)
        addRightBtn(imageView, onClickListener)
    }

    protected fun addRightBtn(view: ImageView, onClickListener: View.OnClickListener) {
        val param =
            LinearLayout.LayoutParams(DensityUtil.dip2px(this, 20f), DensityUtil.dip2px(this, 20f))
        addRightBtn(view, param,onClickListener)
    }

    protected fun addRightBtn(rightTitle: String, onClickListener: View.OnClickListener) {
        val textView = TextView(this)
        textView.text = rightTitle
        addRightBtn(textView, onClickListener)
    }

    protected fun addRightBtn(view: TextView, onClickListener: View.OnClickListener) {
        val param = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        addRightBtn(view, param,onClickListener)
    }

    protected fun addRightBtn(
        view: View,
        param: LinearLayout.LayoutParams,
        onClickListener: View.OnClickListener
    ) {
        param.leftMargin=DensityUtil.dip2px(this,5f)
        param.rightMargin=DensityUtil.dip2px(this,5f)
        titleBinding.llRight.addView(view, param)
        titleBinding.llRight.visibility=View.VISIBLE
        view.setOnClickListener(onClickListener)
    }

}
