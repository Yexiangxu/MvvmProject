package com.lazyxu.base.view.webview;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;

/**
 * User:Lazy_xu
 * Data:2019/10/25
 * Description:
 * FIXME
 */
public class MyJavascriptInterface {
    private Context context;
    public MyJavascriptInterface(Context context) {
        this.context = context;
    }
    @JavascriptInterface
    public void startFunction() {
        Log.e("startFunction", "无参");
    }
    @JavascriptInterface
    public void startFunction(String data) {
        Log.e("startFunction", "有参" + data);
    }
}
