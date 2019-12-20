package com.lazyxu.base.base.head;

/**
 * Author: wendjia
 * Time: 2018\9\4 0004
 * Description:
 **/
public class HeadToolbar {
    private int layoutId = -1;
    private int titleBar = -1;
    private int toolbarTitle = -1;
    private int backDrawable = -1;
    private int toolbarTitleColor = -1;


    public int getToolbarTitleColor() {
        return toolbarTitleColor;
    }

    public int getTitleBar() {
        return titleBar;
    }

    public void setTitleBar(int titleBar) {
        this.titleBar = titleBar;
    }
    void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }
    public int getLayoutId() {
        return this.layoutId;
    }

    public int getBackDrawable() {
        return backDrawable;
    }
    public void setBackDrawable(int backDrawable) {
        this.backDrawable = backDrawable;
    }

    private int toolbarBgColor = -1;
    private int toolbarTitleSize = -1;

    private boolean hideBack = false;



    private int menuId = -1;
    private int loadingTargetView = -1;


    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public void setToolbarTitleSize(int size) {
        this.toolbarTitleSize = size;
    }

    public int getToolbarTitle() {
        return toolbarTitle;
    }

    public void setToolbarTitle(int toolbarTitle) {
        this.toolbarTitle = toolbarTitle;
    }


    public void setToolbarTitleColor(int toolbarTitleColor) {
        this.toolbarTitleColor = toolbarTitleColor;
    }


    public void setToolbarBgColor(int toolbarBgColor) {
        this.toolbarBgColor = toolbarBgColor;
    }




    public void setLoadingTargetView(int loadingTargetView) {
        this.loadingTargetView = loadingTargetView;
    }





    public void setHideBack(boolean hideBack) {
        this.hideBack = hideBack;
    }




}
