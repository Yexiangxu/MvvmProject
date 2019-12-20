package com.lazyxu.user.di;

import androidx.lifecycle.ViewModelProvider;

import com.lazyxu.user.ViewModelFactory;

import dagger.Binds;
import dagger.Module;

@Module(includes = ViewModelModule.class)
public abstract class ViewModelFactoryModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory viewModelFactory);
}
