package com.lazyxu.base.base.head


class HeadToolbar {
    var layoutId = -1
        internal set
    var titleBar = -1
    var toolbarTitle = -1
    var backDrawable = -1
    var toolbarTitleColor = -1

    private var toolbarBgColor = -1
    private var toolbarTitleSize = -1

    private var hideBack = false


    private var menuId = -1
    private var loadingTargetView = -1


    fun setMenuId(menuId: Int) {
        this.menuId = menuId
    }

    fun setToolbarTitleSize(size: Int) {
        this.toolbarTitleSize = size
    }


    fun setToolbarBgColor(toolbarBgColor: Int) {
        this.toolbarBgColor = toolbarBgColor
    }


    fun setLoadingTargetView(loadingTargetView: Int) {
        this.loadingTargetView = loadingTargetView
    }


    fun setHideBack(hideBack: Boolean) {
        this.hideBack = hideBack
    }


}
