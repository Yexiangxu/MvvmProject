//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.lazyxu.base.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import java.util.Stack;

public class ActivityStack {
  private Stack<Activity> mActivities = new Stack();
  private static final String TAG = "ActivityStack";
  private static ActivityStack INSTANCE;

  private ActivityStack() {
  }

  public static ActivityStack getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new ActivityStack();
    }

    return INSTANCE;
  }
  public void popAllActivity(boolean isForceClose) {
    while(this.mActivities.size() > 0) {
      this.popActivity();
    }
    if (isForceClose) {
      Process.killProcess(Process.myPid());
      System.exit(-1);
    }
  }

  public void popActivity() {
    if (this.mActivities != null && !this.mActivities.isEmpty()) {
      Activity activity = this.mActivities.pop();
      if (activity != null) {
        activity.finish();
        activity = null;
      }
    }
  }
  public void popAllActivityExceptTop() {
    while(this.mActivities.size() > 1) {
      Activity activity = this.mActivities.get(0);
      this.mActivities.remove(activity);
      if (activity != null) {
        activity.finish();
        activity = null;
      }
    }
  }






  public void popActivity(Activity activity) {
    if (this.mActivities != null && !this.mActivities.isEmpty() && this.mActivities.contains(activity)) {
      this.mActivities.remove(activity);
      if (activity != null) {
        activity.finish();
        activity = null;
      }
    }

  }

  public Activity topActivity() {
    return this.mActivities.empty() ? null : (Activity)this.mActivities.lastElement();
  }

  public void pushActivity(Activity activity) {
    this.mActivities.add(activity);
  }




  public void reStartApp(Context mContext, Class<?> className) {
    Intent intent = new Intent(mContext, className);
    intent.addFlags(335544320);
    mContext.startActivity(intent);
    Process.killProcess(Process.myPid());
  }

  public void popActivityUntilCls(Class<?> clz) {
    while(this.mActivities.size() > 1 && this.topActivity().getClass() != clz) {
      this.popActivity();
    }

  }

  public void popAllActivityExceptBottom() {
    int size = this.mActivities.size();

    for(int i = size - 1; i >= 1; --i) {
      Activity activity = (Activity)this.mActivities.get(i);
      this.mActivities.remove(activity);
      if (activity != null) {
        activity.finish();
      }
    }

  }

  public int size() {
    return this.mActivities.size();
  }

  public Activity activityAt(int position) {
    return position < this.mActivities.size() ? (Activity)this.mActivities.elementAt(position) : null;
  }
}
