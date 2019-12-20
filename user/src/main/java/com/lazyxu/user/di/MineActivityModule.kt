package com.lazyxu.user.di


import com.lazyxu.user.ui.login.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class UserActivityModule {
    @ContributesAndroidInjector
    internal abstract fun bindLoginActivity(): LoginActivity

}

