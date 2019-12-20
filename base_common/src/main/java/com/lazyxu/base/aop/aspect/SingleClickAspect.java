package com.lazyxu.base.aop.aspect;

import android.view.View;

import com.lazyxu.base.R;
import com.orhanobut.logger.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Calendar;

/**
 * 防止View被连续点击,间隔时间600ms
 */

@Aspect
public class SingleClickAspect {
    static int TIME_TAG = R.id.click_time;
    private static final int MIN_CLICK_DELAY_TIME = 600;

    /**
     * 方法切入点
     */
    @Pointcut("execution(@com.lazyxu.base.aop.annotation.SingleClick * *(..))")
    public void singleClickBehavior() {
    }

    @Around("singleClickBehavior()")//在连接点进行方法替换
    public void aroundJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        View view = null;
        for (Object arg : joinPoint.getArgs())
            if (arg instanceof View) view = (View) arg;
        if (view != null) {
            Object tag = view.getTag(TIME_TAG);
            long lastClickTime = ((tag != null) ? (long) tag : 0);
            Logger.i("SingleClickAspect" + "lastClickTime:" + lastClickTime);
            long currentTime = Calendar.getInstance().getTimeInMillis();
            if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {//过滤掉600毫秒内的连续点击
                view.setTag(TIME_TAG, currentTime);
                Logger.i("SingleClickAspect" + "currentTime:" + currentTime);
                joinPoint.proceed();//执行原方法
            }
        }
    }
}
