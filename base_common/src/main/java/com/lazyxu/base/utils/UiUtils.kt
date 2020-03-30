package com.lazyxu.base.utils

import android.text.SpannableString
import android.text.Spanned
import android.text.SpannedString
import android.text.style.AbsoluteSizeSpan
import android.widget.EditText

object UiUtils {
    fun setHint(editText: EditText, string: String?, size: Int) {
        val ss = SpannableString(string) //定义hint的值
        val ass = AbsoluteSizeSpan(size, true) //设置字体大小 true表示单位是sp
        ss.setSpan(ass, 0, ss.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        editText.hint = SpannedString(ss)
    }
}