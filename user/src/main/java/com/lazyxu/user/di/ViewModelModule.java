package com.lazyxu.user.di;

import androidx.lifecycle.ViewModel;

import com.lazyxu.base.di.scope.ViewModelKey;
import com.lazyxu.user.ui.login.LoginViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    abstract ViewModel bindLoginViewModel(LoginViewModel viewModel);


}
