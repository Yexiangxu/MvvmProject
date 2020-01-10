package com.lazyxu.base.router;

import android.content.Context;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lazyxu.base.utils.Constants;
import com.lazyxu.base.utils.SpUtilDelete;
import com.orhanobut.logger.Logger;

/**
 * priority 值越小，优先级越高
 */
@Interceptor(name = "login", priority = 6)
public class LoginInterceptorImpl implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        boolean isLogin = SpUtilDelete.getBoolean(Constants.SP_IS_LOGIN);
        if (!isLogin) {
            String path = postcard.getPath();
            Bundle bundle = postcard.getExtras();
            ARouter.getInstance().build(RouterUrl.User.LOGIN).with(bundle).withString(RouterUrl.PATH, path).greenChannel().navigation();
        } else {
            callback.onContinue(postcard);
        }
    }
    @Override
    public void init(Context context) {
        Logger.d("路由登录拦截器初始化成功,只会在application时走一次");
    }
}
