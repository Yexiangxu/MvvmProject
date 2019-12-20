package com.lazyxu.film.di.module

import com.lazyxu.film.data.FilmApiService
import com.lazyxu.film.data.FilmRepository
import com.lazyxu.film.data.FilmRepositoryImp
import com.lazyxu.film.data.FilmUseCase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class FilmAppModule {
    /**
     * @return FilmApiService 供FilmRepositoryImp中使用
     */
    @Singleton
    @Provides
    fun provideFilmApiService(retrofit: Retrofit): FilmApiService {
        return retrofit.create(FilmApiService::class.java)
    }

    /**
     * @return FilmRepository 供下面 provideMineUseCase 方法使用
     */
    @Singleton
    @Provides
    fun provideFilmRepositoryImp(mineRepositoryImp: FilmRepositoryImp): FilmRepository {
        return mineRepositoryImp
    }

    /**
     * @return FilmUseCase 供接口调用
     */
    @Singleton
    @Provides
    fun provideFilmUseCase(filmRepository: FilmRepository): FilmUseCase {
        return FilmUseCase(filmRepository)
    }
}


