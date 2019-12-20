package com.lazyxu.film.di.module


import com.lazyxu.film.ui.HotFilmActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FilmActivityModule {
    @ContributesAndroidInjector
    internal abstract fun bindHotFilmActivity(): HotFilmActivity

}

