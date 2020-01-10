package com.lazyxu.base.utils

import android.os.CountDownTimer
import android.widget.TextView

import java.lang.ref.WeakReference

/**
 * User:Lazy_xu
 * Data:2020/01/02
 * Description:
 * FIXME
 */
class TimeCounter(textView: TextView, millisInFuture: Long, countDownInterval: Long) : CountDownTimer(millisInFuture, countDownInterval) {

    private val weakText: WeakReference<TextView> = WeakReference(textView)

    override fun onFinish() {
        setText("发送验证码")
    }

    override fun onTick(millisUntilFinished: Long) {
        setText(millisUntilFinished.toInt().toString().plus("S"))
    }

    private fun setText(text: String) {
        weakText.get()?.text = text
    }
}

