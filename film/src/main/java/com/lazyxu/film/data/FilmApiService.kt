package com.lazyxu.film.data

import com.lazyxu.film.data.entity.ComingFilmEntity
import com.lazyxu.film.data.entity.FilmDetailEntity
import com.lazyxu.film.data.entity.MtimeFilmeEntity
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmApiService {

    /**
     * 时光网热映电影
     */
    @GET("https://api-m.mtime.cn/Showtime/LocationMovies.api?locationId=561")
    fun hotFilm(): Flowable<MtimeFilmeEntity>

    /**
     * 时光网即将上映电影
     */
    @GET("https://api-m.mtime.cn/Movie/MovieComingNew.api?locationId=561")
    fun comingFilm(): Flowable<ComingFilmEntity>

    /**
     * 获取电影详情
     */
    @GET("https://api-m.mtime.cn/movie/detail.api?locationId=561")
    fun getFilmDetail(@Query("movieId") movieId: Int): Flowable<FilmDetailEntity>
}
