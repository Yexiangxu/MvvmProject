package com.lazyxu.base.aop.aspect;

import android.view.View;

import com.lazyxu.base.R;
import com.lazyxu.base.utils.LogUtil;
import com.orhanobut.logger.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Calendar;

/**
 * 防止View被连续点击,间隔时间600ms
 */

@Aspect
public class SingleClickAspect {
    static int TIME_TAG = R.id.click_time;
    private static final int CLICK_DELAY_TIME = 600;

    /**
     * Aroud表示方法前后各插入代码，包含Before和After的全部功能
     * 第一个 * 表示返回值为任意类型
     * (..)为任意类型,()里面为方法的参数
     */
    @Around("execution(* android.view.View.OnClickListener.onClick(..))")
    public void aroundJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        View view = null;
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof View) {
                view = (View) arg;
                break;
            }
        }
        if (view != null) {
            Object tag = view.getTag(TIME_TAG);
            long lastClickTime = ((tag != null) ? (long) tag : 0);
            Logger.i(LogUtil.ASPECT + "LastClickTime:" + lastClickTime);
            long currentTime = Calendar.getInstance().getTimeInMillis();
            if (currentTime - lastClickTime > CLICK_DELAY_TIME) {
                view.setTag(TIME_TAG, currentTime);
                Logger.i(LogUtil.ASPECT + "CurrentClickTime:" + currentTime);
                joinPoint.proceed();//执行原方法
            } else {
                Logger.i(LogUtil.ASPECT + "防重点击起效");
            }
        }
    }
}
