package com.lazyxu.base.base

import android.app.Application

import androidx.lifecycle.AndroidViewModel

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * User: Lazy_xu
 * Data: 2019/07/05
 * Description:
 * FIXME
 */
open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    private val mCompositeDisposable = CompositeDisposable()

    fun addSubscribe(disposable: Disposable) {
        mCompositeDisposable.add(disposable)
    }

    public override fun onCleared() {
        mCompositeDisposable.clear()
        super.onCleared()
    }
}
