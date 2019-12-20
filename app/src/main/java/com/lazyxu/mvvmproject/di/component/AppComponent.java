package com.lazyxu.mvvmproject.di.component;

import android.app.Application;

import com.lazyxu.base.di.module.AppModule;
import com.lazyxu.base.di.module.HttpModule;
import com.lazyxu.film.di.module.FilmActivityModule;
import com.lazyxu.film.di.module.FilmAppModule;
import com.lazyxu.mvvmproject.MainApplication;
import com.lazyxu.user.di.UserActivityModule;
import com.lazyxu.user.di.UserAppModule;
import com.lazyxu.user.di.ViewModelFactoryModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * User: Lazy_xu
 * Data: 2019/07/22
 * Description:
 * FIXME
 */
@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class, HttpModule.class,
        FilmActivityModule.class, FilmAppModule.class,
        UserActivityModule.class, UserAppModule.class, ViewModelFactoryModule.class})
public interface AppComponent {
    void inject(MainApplication mainApplication);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}


