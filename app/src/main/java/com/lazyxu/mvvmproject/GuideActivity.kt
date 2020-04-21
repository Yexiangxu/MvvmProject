package com.lazyxu.mvvmproject

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.alibaba.android.arouter.facade.annotation.Route
import com.lazyxu.base.router.RouterUrl
import com.lazyxu.base.view.banner.DrawableIndicator
import com.lazyxu.mvvmproject.databinding.ActivityGuideBinding
import com.lazyxu.mvvmproject.databinding.ActivitySplashBinding
import com.zhpan.bannerview.constants.IndicatorGravity
import com.zhpan.indicator.base.IIndicator
import com.zhpan.indicator.enums.IndicatorSlideMode
import kotlinx.android.synthetic.main.activity_guide.*

/**
 * User: xuyexiang
 * Date: 2019/06/11
 * Description:
 * FIXME
 */
@Route(path = RouterUrl.GUIDE)
class GuideActivity : Activity() {
    private lateinit var mdatabinding: ActivityGuideBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mdatabinding = DataBindingUtil.setContentView(this, R.layout.activity_guide)
        initViewPager()
    }

    private fun initViewPager() {
        vpGuide.setIndicatorView(getVectorDrawableIndicator())
                .setIndicatorSlideMode(IndicatorSlideMode.NORMAL)
                .setIndicatorVisibility(View.VISIBLE)
                .setIndicatorGravity(IndicatorGravity.CENTER)
                .create(ArrayList())
    }


    private fun getVectorDrawableIndicator(): IIndicator {
        val dp6 = resources.getDimensionPixelOffset(R.dimen.dp6)
        return DrawableIndicator(this)
                .setIndicatorGap(resources.getDimensionPixelOffset(R.dimen.dp2_5))
                .setIndicatorDrawable(R.drawable.banner_indicator_nornal, R.drawable.banner_indicator_focus)
                .setIndicatorSize(dp6, dp6, resources.getDimensionPixelOffset(R.dimen.dp13), dp6)
    }

}
