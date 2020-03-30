package com.lazyxu.film.model

import com.lazyxu.film.model.entity.ComingFilmEntity
import com.lazyxu.film.model.entity.FilmDetailEntity
import com.lazyxu.film.model.entity.MtimeFilmeEntity
import io.reactivex.Flowable

interface FilmRepository {
    fun hotFilm(): Flowable<MtimeFilmeEntity>

    fun comingFilm(): Flowable<ComingFilmEntity>

    fun getFilmDetail(movieId: Int): Flowable<FilmDetailEntity>
}
