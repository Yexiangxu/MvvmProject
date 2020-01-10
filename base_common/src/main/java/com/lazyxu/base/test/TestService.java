package com.lazyxu.base.test;

import android.content.Context;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * User: Lazy_xu
 * Data: 2019/12/16
 * Description: 放在所有module可以使用的地方
 * FIXME
 */
public interface TestService extends IProvider {
    public void showToast(Context context);
}
