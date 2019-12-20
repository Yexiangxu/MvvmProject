package com.lazyxu.base.base.head;

import androidx.annotation.ColorRes;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.StringRes;

/**
 * Author: wendjia
 * Time: 2018\9\4 0004
 * Description:
 *
 * @See com.mmkjflb.baselibrary.annotation.ActivityFragmentInject
 **/

public interface IHeaderBuilder {
    HeaderBuilder layoutId(@LayoutRes int layoutId);

    HeaderBuilder titleBar(@IdRes int titleBar);


    HeaderBuilder menuId(int menuId);

    HeaderBuilder toolbarTitle(@StringRes int toolbarTitle);

    HeaderBuilder toolbarTitleSize(@StringRes int textSize);

    HeaderBuilder toolbarTitleColor(@ColorRes int toolbarTitleColor);

    HeaderBuilder toolbarBgColor(@ColorRes int toolbarBgColor);

    HeaderBuilder backDrawable(@ColorRes int backDrawable);

    HeaderBuilder loadingTargetView(@LayoutRes int loadingTargetView);


    HeaderBuilder hideBack(boolean hideBack);

}
