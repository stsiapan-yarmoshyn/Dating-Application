package com.example.feature_login_impl.di

import com.example.feature_login_api.usecase.LoginUserUseCase
import com.example.feature_login_api.usecase.SaveUserUseCase
import com.example.feature_login_impl.data.usecase.LoginUserUseCaseImpl
import com.example.feature_login_impl.data.usecase.SaveUserUseCaseImpl
import com.example.feature_login_impl.screen.LoginViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val loginModule = module {
    viewModelOf(::LoginViewModel)
    factoryOf(::LoginUserUseCaseImpl) { bind<LoginUserUseCase>() }
    factoryOf(::SaveUserUseCaseImpl) { bind<SaveUserUseCase>() }
}
