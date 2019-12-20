package com.lazyxu.base.aop.aspect;

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
 * 处理切点
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
        Logger.i(LogUtil.ASPECT);
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        CheckNet checkNet = signature.getMethod().getAnnotation(CheckNet.class);
        if (checkNet != null) {
            // 2.判断有没有网络  怎么样获取 context?
            Object object = joinPoint.getThis();// View Activity Fragment ； getThis() 当前切点方法所在的类
            if (!NetUtils.isNetworkConnected()) {
                AppToast.INSTANCE.show("请检查您的网络");
                return null;
            }
        }
        //执行原方法
        return joinPoint.proceed();
    }
}
