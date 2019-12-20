package com.lazyxu.base.view;

import android.content.Context;
import android.content.Intent;

/**
 * User: Lazy_xu
 * Data: 2019/07/05
 * Description:
 * FIXME
 */
public class Test {
    public static void gag(Context context){
        Intent intent=new Intent();
        intent.setAction("com.action.test");
        context.startActivity(intent);
    }
}
