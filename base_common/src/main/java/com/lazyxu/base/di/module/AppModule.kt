package com.lazyxu.base.di.module

import android.app.Application
import android.content.Context
import com.lazyxu.base.R
import dagger.Module
import dagger.Provides
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import javax.inject.Singleton

/**
 * User: Lazy_xu
 * Data: 2019/07/23
 * Description:
 * FIXME
 */
@Module
class AppModule {
    @Singleton
    @Provides
    internal fun provideApplication(application: Application): Context {
        return application
    }

//    @Provides
//    @Singleton
//    internal fun provideCalligraphyDefaultConfig(): CalligraphyConfig {
//        return CalligraphyConfig.Builder()
//                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
//                .setFontAttrId(R.attr.fontPath)
//                .build()
//    }
}
