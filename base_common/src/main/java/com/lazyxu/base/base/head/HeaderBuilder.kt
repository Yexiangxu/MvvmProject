package com.lazyxu.base.base.head

import androidx.annotation.IdRes
import androidx.annotation.LayoutRes

class HeaderBuilder : IHeaderBuilder {
    private val headToolbar = HeadToolbar()


    override fun layoutId(@LayoutRes layoutId: Int): HeaderBuilder {
        headToolbar.layoutId = layoutId
        return this
    }

    override fun toolBarRes(@IdRes toolBar: Int): HeaderBuilder {
        headToolbar.toolBar = toolBar
        return this
    }
    override fun backDrawable(backDrawable: Int): HeaderBuilder {
        headToolbar.backDrawable = backDrawable
        return this
    }


    override fun toolbarTitle(toolbarTitle: Any): HeaderBuilder {
        headToolbar.toolbarTitle = toolbarTitle
        return this
    }













    override fun menuId(menuId: Int): HeaderBuilder {
        headToolbar.setMenuId(menuId)
        return this
    }



    override fun toolbarTitleSize(textSize: Int): HeaderBuilder {
        headToolbar.setToolbarTitleSize(textSize)
        return this
    }

    override fun toolbarTitleColor(toolbarTitleColor: Int): HeaderBuilder {
        headToolbar.toolbarTitleColor = toolbarTitleColor
        return this
    }

    override fun toolbarBgColor(toolbarBgColor: Int): HeaderBuilder {
        headToolbar.setToolbarBgColor(toolbarBgColor)
        return this
    }



    override fun loadingTargetView(loadingTargetView: Int): HeaderBuilder {
        headToolbar.setLoadingTargetView(loadingTargetView)
        return this
    }


    override fun hideBack(hideBack: Boolean): HeaderBuilder {
        headToolbar.setHideBack(hideBack)
        return this
    }

    fun build(): HeadToolbar {
        return headToolbar
    }
}
