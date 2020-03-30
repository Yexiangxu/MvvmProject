package com.lazyxu.user.di

import com.lazyxu.base.data.retrofit
import com.lazyxu.user.data.UserApiService
import com.lazyxu.user.data.repository.UserRepositoryImpl
import com.lazyxu.user.ui.loginorregister.LoginOrRegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

/*
 * User:lazy_xu
 * Data: 2020/1/7
 * Description:
 * FIXME
 */
val repositoryModule = module {
    single { retrofit(context = get()) }
    single<UserApiService> { get<Retrofit>().create(UserApiService::class.java) }
    single { UserRepositoryImpl(get()) }
}

val viewModelModule = module {
    viewModel { LoginOrRegisterViewModel(get()) }

}
val mineModule = listOf(viewModelModule, repositoryModule)