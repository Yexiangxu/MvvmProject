package com.lazyxu.base.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.res.Resources
import android.text.TextUtils

import com.lazyxu.base.base.BaseApplication
import com.orhanobut.logger.Logger

/**
 * User: xuyexiang
 * Date: 2019/06/13
 * Description:
 * FIXME
 */
object CommonUtils {
    /**
    public static Resources getResoure() {
    return BaseApplication.getInstance().getResources();
    }

    public static float getDimens(int resId) {
    return getResoure().getDimension(resId);
    }
     */
    val resoure: Resources
        get() = BaseApplication.getInstance().resources

    fun getDimens(resId: Int): Float {
        return resoure.getDimension(resId)
    }

    fun copy(content: String) {
        if (!TextUtils.isEmpty(content)) {
            val clipboard = BaseApplication.getInstance().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText(content, content)
            clipboard.primaryClip = clip
        }
    }

    /**
     * 获取系统剪切板内容
     */
    fun getClipContent(): String {
        val manager = BaseApplication.getInstance().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        if (manager.hasPrimaryClip() && manager.primaryClip!!.itemCount > 0) {
            val addedText = manager.primaryClip!!.getItemAt(0).text
            val addedTextString = addedText.toString()
            if (!TextUtils.isEmpty(addedTextString)) {
                return StringFormatUtil.formatUrl(addedText.toString())
            }
        }
        return ""
    }
    /**
     * 清空剪切板内容
     * 加上  manager.setText(null);  不然小米3Android6.0 清空无效
     * 因为api过期使用最新注意使用 manager.getPrimaryClip()，不然小米3Android6.0 清空无效
     */
    fun clearClipboard() {
        val manager = BaseApplication.getInstance().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        if (manager != null) {
            try {
                manager.primaryClip = manager.primaryClip!!
                manager.text = null
            } catch (e: Exception) {
                Logger.e(e.message.toString())
            }

        }
    }
}
