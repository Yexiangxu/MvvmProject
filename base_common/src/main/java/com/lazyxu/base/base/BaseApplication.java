package com.lazyxu.base.base;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.stetho.Stetho;
import com.lazyxu.base.BuildConfig;
import com.lazyxu.base.utils.DeviceUtil;
import com.lazyxu.base.utils.ScreenAdapterUtil;
import com.lazyxu.base.utils.SpUtil;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;


/**
 * User: Lazy_xu
 * Data: 2019/07/22
 * Description:
 * FIXME
 */
public class BaseApplication extends Application {
    //    @Inject
//    CalligraphyConfig calligraphyConfig;
    private static BaseApplication MINSTATCE = null;
    private long currentTime = 0L;

    public static BaseApplication getInstance() {
        return MINSTATCE;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        currentTime = System.currentTimeMillis();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MINSTATCE = this;
        if (getPackageName().equals(DeviceUtil.INSTANCE.getProcessName())) {
            initDebug();
            SpUtil.init(this);
            ScreenAdapterUtil.setDensity(this, 360);
            //今日头条屏幕适配（宽高不能同时适配，这里只做了宽度竖屏适配，如果有横竖屏切换还需处理）
            initThirdPart();
        }
        //耗时110ms
        ARouter.init(MINSTATCE);
    }

    /**
     * 初始化各种第三方耗时操作
     */
    private void initThirdPart() {
        //        CalligraphyConfig.initDefault(calligraphyConfig);
        new Thread() {
            @Override
            public void run() {
                super.run();

            }
        }.start();
    }

    private void initDebug() {
        if (BuildConfig.DEBUG) {
            Logger.addLogAdapter(new AndroidLogAdapter());
            // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();
            ARouter.openDebug();
            if (LeakCanary.isInAnalyzerProcess(this)) {
                return;
            }
            LeakCanary.install(this);
            Stetho.initializeWithDefaults(this);
        }
    }
}
