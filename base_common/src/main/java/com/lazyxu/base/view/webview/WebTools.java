package com.lazyxu.base.view.webview;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;

import com.lazyxu.base.R;
import com.lazyxu.base.base.BaseApplication;


/**
 * Created by jingbin on 2017/2/13.
 */

public class WebTools {

    /**
     * 实现文本复制功能
     *
     * @param content 复制的文本
     */
    public static void copy(String content) {
        if (!TextUtils.isEmpty(content)) {
            ClipboardManager clipboard = (ClipboardManager) BaseApplication.INSTANCE.getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText(content, content);
            clipboard.setPrimaryClip(clip);
        }
    }

    /**
     * 使用浏览器打开链接
     */
    public static void openLink(Context context, String content) {
        if (!TextUtils.isEmpty(content) && content.startsWith("http")) {
            Uri issuesUrl = Uri.parse(content);
            Intent intent = new Intent(Intent.ACTION_VIEW, issuesUrl);
            context.startActivity(intent);
        }
    }

    /**
     * 分享
     */
    public static void share(Context context, String extraText) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, context.getString(R.string.share));
        intent.putExtra(Intent.EXTRA_TEXT, extraText);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(Intent.createChooser(intent, context.getString(R.string.share)));
    }

    /**
     * 通过包名找应用,不需要权限
     */
    public static boolean hasPackage(Context context, String packageName) {
        if (null == context || TextUtils.isEmpty(packageName)) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(packageName, PackageManager.GET_GIDS);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            // 抛出找不到的异常，说明该程序已经被卸载
            return false;
        }
    }

    /**
     * 处理三方链接
     * 网页里可能唤起其他的app
     */
    public static boolean handleThirdApp(Activity activity, String backUrl) {
        //http开头直接跳过
        if (backUrl.startsWith("http")) {
            // 可能有提示下载Apk文件
            if (backUrl.contains(".apk")) {
                startActivity(activity, backUrl);
                return true;
            }
            return false;
        }

        boolean isJump = true;
        //屏蔽以下应用唤起App，可根据需求 添加或取消
        if (backUrl.startsWith("tbopen:")// 淘宝
//                        || backUrl.startsWith("openapp.jdmobile:")// 京东
//                        || backUrl.startsWith("jdmobile:")//京东
//                        || backUrl.startsWith("alipay:")// 支付宝
//                        || backUrl.startsWith("alipays:")//支付宝  https://docs.open.alipay.com/203/107091/
                        || backUrl.startsWith("zhihu:")// 知乎
                        || backUrl.startsWith("vipshop:")//
                        || backUrl.startsWith("youku:")//优酷
                        || backUrl.startsWith("uclink:")// UC
                        || backUrl.startsWith("ucbrowser:")// UC
                        || backUrl.startsWith("newsapp:")//
                        || backUrl.startsWith("sinaweibo:")// 新浪微博
                        || backUrl.startsWith("suning:")//
                        || backUrl.startsWith("pinduoduo:")// 拼多多
                        || backUrl.startsWith("baiduboxapp:")// 百度
                        || backUrl.startsWith("qtt:")//
        ) {
            isJump = false;
        }
        if (isJump) {
            startActivity(activity, backUrl);
        }
        return isJump;
    }

    /**
     * 可处理webview中有电话拨打电话
     */
    private static void startActivity(Context context, String url) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(url));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
