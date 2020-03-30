package com.lazyxu.film.model

import com.lazyxu.base.utils.RxUtils
import com.lazyxu.film.model.entity.ComingFilmEntity
import com.lazyxu.film.model.entity.FilmDetailEntity
import com.lazyxu.film.model.entity.MtimeFilmeEntity
import io.reactivex.Flowable

/**
 * impl 子包中一般存放 仓储中的实现类
 */
class FilmRepositoryImp constructor(private val filmApiService: FilmApiService) : FilmRepository {

    override fun hotFilm(): Flowable<MtimeFilmeEntity> {
        return filmApiService.hotFilm().compose(RxUtils.rxSchedulerHelper())
    }

    override fun comingFilm(): Flowable<ComingFilmEntity> {
        return filmApiService.comingFilm().compose(RxUtils.rxSchedulerHelper())
    }

    override fun getFilmDetail(movieId: Int): Flowable<FilmDetailEntity> {
        return filmApiService.getFilmDetail(movieId).compose(RxUtils.rxSchedulerHelper())
    }
}


