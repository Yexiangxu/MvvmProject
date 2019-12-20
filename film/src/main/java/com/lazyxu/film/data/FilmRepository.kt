package com.lazyxu.film.data

import com.lazyxu.film.data.entity.ComingFilmEntity
import com.lazyxu.film.data.entity.FilmDetailEntity
import com.lazyxu.film.data.entity.MtimeFilmeEntity
import io.reactivex.Flowable

interface FilmRepository {
    fun hotFilm(): Flowable<MtimeFilmeEntity>

    fun comingFilm(): Flowable<ComingFilmEntity>

    fun getFilmDetail(movieId: Int): Flowable<FilmDetailEntity>
}
