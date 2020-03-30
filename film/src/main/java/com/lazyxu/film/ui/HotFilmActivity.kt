package com.lazyxu.film.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.lazyxu.base.router.RouterUrl

/**
 * User: Lazy_xu
 * Data: 2019/07/22
 * Description:
 * FIXME
 */
@Route(path = RouterUrl.HOTFILM)
class HotFilmActivity : AppCompatActivity() {
//    @Inject
//    lateinit var mineUseCase: FilmUseCase
//    lateinit var mDatabinding: ActivityHotfilmBinding

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        mDatabinding = DataBindingUtil.setContentView(this, R.layout.activity_hotfilm)
//        mineUseCase.hotFilm().subscribe({ mtimeFilmeEntity ->
//            mDatabinding.rvHotfilm.layoutManager = LinearLayoutManager(this@HotFilmActivity)
//            mDatabinding.rvHotfilm.adapter = HotFilmAdapter(R.layout.item_hotfilm, mtimeFilmeEntity.ms)
//        }, { throwable ->
//
//        })
    }

}
