package com.lazyxu.base.aop.aspect;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import androidx.fragment.app.Fragment;

import com.lazyxu.base.aop.annotation.CheckNet;
import com.lazyxu.base.utils.AppToast;
import com.lazyxu.base.utils.LogUtil;
import com.lazyxu.base.utils.NetUtils;
import com.orhanobut.logger.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * 使用@Aspect注解，编译器在编译的时候就会自动去解析，并不需要主动去调用AspectJ类里面的代码
 */
@Aspect
public class NetworkAspect {
    /**
     * 找到处理的切点 可以处理所有的方法
     */
    @Pointcut("execution(@com.lazyxu.base.aop.annotation.CheckNet * *(..))")
    public void checkNetBehavior() {
    }


    /**
     * 处理切面
     */
    @Around("checkNetBehavior()")
    public Object checkNet(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        CheckNet checkNet = signature.getMethod().getAnnotation(CheckNet.class);
        if (checkNet != null) {
            Object object = joinPoint.getThis();
            Context context = getContext(object);
            if (context != null) {
                if (!NetUtils.isNetworkConnected(context)) {
                    AppToast.INSTANCE.show("请检查您的网络");
                    return null;
                }
            }
        }
        Logger.i(LogUtil.ASPECT + "CheckNet");
        //执行原方法
        return joinPoint.proceed();
    }

    private Context getContext(Object object) {
        if (object instanceof Activity) {
            return (Activity) object;
        } else if (object instanceof Fragment) {
            Fragment fragment = (Fragment) object;
            return fragment.getActivity();
        } else if (object instanceof View) {
            View view = (View) object;
            return view.getContext();
        }
        return null;
    }
}
