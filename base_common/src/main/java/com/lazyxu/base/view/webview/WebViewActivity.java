package com.lazyxu.base.view.webview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.lazyxu.base.R;
import com.lazyxu.base.utils.NetUtils;
import com.lazyxu.base.router.RouterUrl;
import com.lazyxu.base.view.WebProgress;

import static android.os.Build.VERSION_CODES.LOLLIPOP;


/**
 * 网页可以处理:
 * 点击相应控件：
 * - 拨打电话、发送短信、发送邮件
 * - 上传图片(版本兼容)
 * - 全屏播放网络视频
 * - 进度条显示
 * - 返回网页上一层、显示网页标题
 * <p>
 * 被作为第三方浏览器打开
 * link to https://github.com/youlookwhat/WebViewStudy
 */
@Route(path = RouterUrl.WEBVIEWMAIN)
public class WebViewActivity extends AppCompatActivity implements IWebView {


    // 进度条
    private WebProgress mProgressBar;
    private WebView webView;
    // 全屏时视频加载view
    private FrameLayout videoFullView;
    // 加载视频相关
    private MyWebChromeClient mWebChromeClient;
    // 网页链接
    private String mUrl;
    private Toolbar mTitleToolBar;
    // 可滚动的title 使用简单 没有渐变效果，文字两旁有阴影
    private TextView tvGunTitle;
    private String mTitle;
    private boolean island = false;


    @Autowired
    public String webUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        webView = findViewById(R.id.wbMain);
        mProgressBar = findViewById(R.id.wbProgress);
        setDefaultWebSettings(webView);
        webView.loadUrl(webUrl);
        getDataFromBrowser(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        getDataFromBrowser(intent);
    }

    /**
     * 作为三方浏览器打开传过来的值
     * Scheme: https
     * host: www.jianshu.com
     * path: /u/471dc120cbb3
     * url = scheme + "://" + host + path;
     * https://www.jianshu.com/u/471dc120cbb3
     */
    private void getDataFromBrowser(Intent intent) {
        Uri data = intent.getData();
        if (data != null) {
            try {
                String scheme = data.getScheme();
                String host = data.getHost();
                String path = data.getPath();
                String text = "Scheme: " + scheme + "\n" + "host: " + host + "\n" + "path: " + path;
                Log.e("data", text);
                String url = scheme + "://" + host + path;
                webView.loadUrl(url);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        webView.onPause();
        webView.pauseTimers();
    }

    @Override
    protected void onResume() {
        super.onResume();
        webView.onResume();
        // 支付宝网页版在打开文章详情之后,无法点击按钮下一步
        webView.resumeTimers();
        // 设置为横屏
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.webview_menu, menu);
//        return true;
//    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:// 返回键
//                finish();
//                break;
//            case R.id.wb_share:// 分享到
//                String shareText = webView.getTitle() + webView.getUrl();
//                WebTools.share(WebViewActivity.this, shareText);
//                break;
//            case R.id.wb_cope:// 复制链接
//                WebTools.copy(webView.getUrl());
//                AppToast.INSTANCE.show("复制成功");
//                break;
//            case R.id.wb_open:// 打开链接
//                WebTools.openLink(WebViewActivity.this, webView.getUrl());
//                break;
//            case R.id.wb_refresh:// 刷新页面
//                webView.reload();
//                break;
//            default:
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void showWebView() {
        webView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hindWebView() {
        webView.setVisibility(View.INVISIBLE);
    }

    @SuppressLint("SetJavaScriptEnabled")
    public void setDefaultWebSettings(WebView webView) {
        //在浏览器输入 chrome://inspect 点击inspect即可
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        WebSettings webSettings = webView.getSettings();
        //5.0以上开启Https和Http混合模式加载
        if (Build.VERSION.SDK_INT >= LOLLIPOP) {
            //5.0yi默认不支持同时加载
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        //缩放至屏幕的大小
        webSettings.setLoadWithOverviewMode(true);
        // 是否应该支持使用其屏幕缩放控件和手势缩放
        webSettings.setSupportZoom(true);
        //设置支持缩放
        webSettings.setBuiltInZoomControls(true);
        //设置webview推荐使用的窗口，使html界面自适应屏幕
        webSettings.setUseWideViewPort(true);
        webSettings.setJavaScriptEnabled(true);
        // 保存表单数据
        webSettings.setSaveFormData(true);
        //允许SessionStorage/LocalStorage存储  解决对某些标签的不支持出现白屏
        webSettings.setDomStorageEnabled(true);
        //设置显示缩放按钮
        webSettings.setDisplayZoomControls(false);
        // 禁用文字缩放，设置字体默认缩放大小(改变网页字体大小,setTextSize  api14被弃用)
        webSettings.setTextZoom(100);
        //允许缓存，设置缓存位置
        webSettings.setAppCacheEnabled(false);
        // 设置缓存模式
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        //按需求定，如果想快速加载之后再渲染图，先设置在这里设置true，onPageFinished再设置false
        webSettings.setBlockNetworkImage(false);
        // 排版适应屏幕
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        //设置可以访问文件
        webSettings.setAllowFileAccess(true);
        if (Build.VERSION.SDK_INT >= LOLLIPOP) {
            webSettings.setLoadsImagesAutomatically(true);
        } else {
            webSettings.setLoadsImagesAutomatically(false);
        }
        //webview滚动拖动到顶部或底部阴影
        webView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        //injectedObject可以随意命名，只要前端跟移动端统一即可
        webView.addJavascriptInterface(new MyJavascriptInterface(this), "injectedObject");
        //辅助WebView处理Javascript的对话框，网站title，加载进度、视屏横竖屏等
        mWebChromeClient = new MyWebChromeClient(this);
        webView.setWebChromeClient(mWebChromeClient);
        webView.setWebViewClient(new MyWebViewClient(this));
    }

    @Override
    public void fullViewAddView(View view) {
        FrameLayout decor = (FrameLayout) getWindow().getDecorView();
        videoFullView = new FullscreenHolder(WebViewActivity.this);
        videoFullView.addView(view);
        decor.addView(videoFullView);
    }

    @Override
    public void showVideoFullView() {
        if (videoFullView != null) {
            videoFullView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hindVideoFullView() {
        if (videoFullView != null) {
            videoFullView.setVisibility(View.GONE);
        }
    }

    @Override
    public void startProgress(int newProgress) {
        mProgressBar.setWebProgress(newProgress);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        if (!NetUtils.isNetworkConnected()) {
            mProgressBar.hide();
        }
    }

    /**
     * 处理是否唤起三方app
     */
    @Override
    public boolean isOpenThirdApp(String url) {
        return WebTools.handleThirdApp(this, url);
    }

    /**
     * 全屏时按返加键执行退出全屏方法
     */
    public void hideCustomView() {
        mWebChromeClient.onHideCustomView();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public FrameLayout getVideoFullView() {
        return videoFullView;
    }

    @Override
    public View getVideoLoadingProgressView() {
        return LayoutInflater.from(this).inflate(R.layout.video_loading_progress, null);
    }

    @Override
    public void onReceivedTitle(WebView view, String title) {
        setTitle(title);
    }

    @Override
    public void startFileChooserForResult(Intent intent, int requestCode) {
        startActivityForResult(intent, requestCode);
    }

    /**
     * 上传图片之后的回调
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == MyWebChromeClient.FILECHOOSER_RESULTCODE) {
            mWebChromeClient.mUploadMessage(intent, resultCode);
        } else if (requestCode == MyWebChromeClient.FILECHOOSER_RESULTCODE_FOR_ANDROID_5) {
            mWebChromeClient.mUploadMessageForAndroid5(intent, resultCode);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //全屏播放退出全屏
            if (mWebChromeClient.inCustomView()) {
                hideCustomView();
                return true;
                //返回网页上一页
            } else if (webView.canGoBack()) {
                webView.goBack();
                return true;
                //退出网页
            } else {
                finish();
            }
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        if (videoFullView != null) {
            videoFullView.removeAllViews();
            videoFullView = null;
        }
        if (webView != null) {
            ViewGroup parent = (ViewGroup) webView.getParent();
            if (parent != null) {
                parent.removeView(webView);
            }
            webView.removeAllViews();
            webView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            webView.stopLoading();
            webView.setWebChromeClient(null);
            webView.setWebViewClient(null);
            // 退出时调用此方法，移除绑定的服务，否则某些特定系统会报错
            webView.getSettings().setJavaScriptEnabled(false);
            webView.destroy();
            webView = null;
        }
        super.onDestroy();
    }

}