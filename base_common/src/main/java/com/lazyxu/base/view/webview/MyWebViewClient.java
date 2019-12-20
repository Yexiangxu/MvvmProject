package com.lazyxu.base.view.webview;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.lazyxu.base.utils.LogUtil;
import com.orhanobut.logger.Logger;

/**
 * Created by jingbin on 2016/11/17.
 * 监听网页链接:
 * - 根据标识:打电话、发短信、发邮件
 * - 进度条的显示
 * - 添加javascript监听
 * - 唤起京东，支付宝，微信原生App
 */
public class MyWebViewClient extends WebViewClient {

    private IWebView mIWebPageView;

    public MyWebViewClient(IWebView mIWebPageView) {
        this.mIWebPageView = mIWebPageView;
    }

    @Nullable
    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        return super.shouldInterceptRequest(view, request);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (TextUtils.isEmpty(url)) {
            return false;
        }
        Logger.d(LogUtil.WEB_VIEW_LOG + "shouldOverrideUrlLoading的url=" + url);
        return mIWebPageView.isOpenThirdApp(url);
//        //解决重定向问题
//        WebView.HitTestResult hitTestResult = view.getHitTestResult();
//        if (!TextUtils.isEmpty(url) && hitTestResult == null) {
//            view.loadUrl(url);
//            Logger.d(LogUtil.WEB_VIEW_LOG+"shouldOverrideUrlLoading重定向的url="+url);
//            return true;
//        }else {
//            Logger.d(LogUtil.WEB_VIEW_LOG+"shouldOverrideUrlLoading的url="+url);
//            return mIWebPageView.isOpenThirdApp(url);
//        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        Logger.d(LogUtil.WEB_VIEW_LOG + "shouldOverrideUrlLoading的request=" + request.getUrl().toString());
        return super.shouldOverrideUrlLoading(view, request);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        Logger.d(LogUtil.WEB_VIEW_LOG + "onPageStarted的url=" + url);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        Logger.d(LogUtil.WEB_VIEW_LOG + "onPageFinished的url=" + url);
        // html加载完成之后，添加监听图片的点击js函数
        mIWebPageView.onPageFinished(view, url);
        super.onPageFinished(view, url);
    }

    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        if (errorCode == 404) {
            //用javascript隐藏系统定义的404页面信息
            String data = "Page NO FOUND！";
            view.loadUrl("javascript:document.body.innerHTML=\"" + data + "\"");
        }
    }

    // SSL Error. Failed to validate the certificate chain,error: java.security.cert.CertPathValidatorExcept
    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        //super.onReceivedSslError(view, handler, error);注意一定要去除这行代码，否则设置无效。
        // handler.cancel();// Android默认的处理方式
        handler.proceed();// 接受所有网站的证书,解决方案, 不要调用super.xxxx
        // handleMessage(Message msg);// 进行其他处理
    }

    // 视频全屏播放按返回页面被放大的问题
    @Override
    public void onScaleChanged(WebView view, float oldScale, float newScale) {
        super.onScaleChanged(view, oldScale, newScale);
        if (newScale - oldScale > 7) {
            view.setInitialScale((int) (oldScale / newScale * 100)); //异常放大，缩回去。
        }
    }

}
