package com.lazyxu.base.utils

import android.app.Activity
import android.content.Context
import android.os.Process
import android.view.inputmethod.InputMethodManager
import java.util.*
import kotlin.system.exitProcess

/**
 * User:Lazy_xu
 * Data:2019/10/10
 * Description: kotlin的静态内部类方式的单例模式
 * FIXME
 */
class ActivityStack private constructor() {
    //stack栈，先进后出
    private var mActivities = Stack<Activity>()

    companion object {
        fun getInstance(): ActivityStack {
            return Holder.INSTANCE
        }
    }

    private object Holder {
        val INSTANCE = ActivityStack()
    }

    fun addActivity(activity: Activity) {
        this.mActivities.add(activity)
    }

    fun removeActivity(activity: Activity?) {
        if (!this.mActivities.isEmpty() && this.mActivities.contains(activity)) {
            this.mActivities.remove(activity)
            activity?.finish()
        }
    }

    fun popAllActivity(isForceClose: Boolean) {
        while (this.mActivities.size > 0) {
            this.popActivity()
        }
        if (isForceClose) {
            Process.killProcess(Process.myPid())
            exitProcess(-1)
        }
    }
    private fun popActivity() {
        if (!this.mActivities.isEmpty()) {
            //pop栈顶元素出栈
            (mActivities.pop() as Activity).finish()
        }
    }
    fun popAllActivityExceptTop() {
        while (this.mActivities.size > 1) {
            val activity: Activity? = this.mActivities[0] as Activity
            this.mActivities.remove(activity)
            activity?.finish()
        }
    }






    private fun hideSoftKeyBoard(activity: Activity) {
        val localView = activity.currentFocus
        val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (localView != null && imm != null) {
            imm.hideSoftInputFromWindow(localView.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }
}
