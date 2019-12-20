package com.lazyxu.base.router;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;

public class LoginNavigationCallbackImpl implements NavigationCallback {
    @Override //找到了
    public void onFound(Postcard postcard) {
    }
    @Override //找不到了
    public void onLost(Postcard postcard) {
    }
    @Override    //跳转成功了
    public void onArrival(Postcard postcard) {
    }
    @Override
    public void onInterrupt(Postcard postcard) {
        String path = postcard.getPath();
        Bundle bundle = postcard.getExtras();
        ARouter.getInstance().build(RouterUrl.LOGIN).with(bundle).withString(RouterUrl.PATH, path).greenChannel().navigation();
    }
}
