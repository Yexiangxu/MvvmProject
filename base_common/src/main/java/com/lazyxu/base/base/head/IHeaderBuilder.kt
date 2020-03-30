package com.lazyxu.base.base.head

import androidx.annotation.ColorRes
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.widget.Toolbar


interface IHeaderBuilder {
    fun layoutId(@LayoutRes layoutId: Int): HeaderBuilder
    fun toolBarRes(@IdRes toolBar: Int): HeaderBuilder


    fun toolbarTitle(toolbarTitle: Any): HeaderBuilder
    fun backDrawable( backDrawable: Int): HeaderBuilder











    fun menuId(@IdRes menuId: Int): HeaderBuilder


    fun toolbarTitleSize(@StringRes textSize: Int): HeaderBuilder

    fun toolbarTitleColor(@ColorRes toolbarTitleColor: Int): HeaderBuilder

    fun toolbarBgColor(@ColorRes toolbarBgColor: Int): HeaderBuilder


    fun loadingTargetView(@LayoutRes loadingTargetView: Int): HeaderBuilder

    fun hideBack(hideBack: Boolean): HeaderBuilder

}
