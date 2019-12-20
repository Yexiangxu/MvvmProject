package com.lazyxu.base.view.webview;

/**
 * User:Lazy_xu
 * Data:2019/10/28
 * Description:
 * FIXME
 */
public class BrowserJsInject {

    /**
     * Js注入
     *
     * @param url 加载的网页地址
     * @return 注入的js内容，若不是需要适配的网址则返回空javascript
     */
    public static String fullScreenByJs(String url) {
        String refer = referParser(url);
        if (null != refer) {
            String js3 = "window.οnlοad=function(){document.getElementsByClassName('"
                    + referParser(url) + "')[0].addEventListener('click',function(){window.FULLSCREEN.eventFun()})}"
                    + ";";

            return "javascript:" + js3;
        } else {

            return "javascript:";
        }
    }

    public static String referParser(String url) {
        if (url.contains("letv")) {
            return "hv_ico_screen";   //乐视Tv
        } else if (url.contains("youku")) {
            return "x-zoomin";//优酷
        } else if (url.contains("bilibili")) {
            return "icon-widescreen"; //bilibili
        } else if (url.contains("qq")) {
            return "tvp_fullscreen_button";   //腾讯视频
        }
        return null;
    }
}