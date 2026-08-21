package com.example.core_database_impl.data.di

import com.example.core_database_api.data.repository.SessionManager
import com.example.core_database_api.data.usecase.session.ClearSessionUseCase
import com.example.core_database_api.data.usecase.session.GetUserTokenUseCase
import com.example.core_database_api.data.usecase.session.SaveUserTokenUseCase
import com.example.core_database_impl.data.session.SessionManagerImpl
import com.example.core_database_impl.usecase.session.ClearSessionUseCaseImpl
import com.example.core_database_impl.usecase.session.GetUserTokenUseCaseImpl
import com.example.core_database_impl.usecase.session.SaveUserTokenUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val sessionModule = module {
    single<SessionManager> { SessionManagerImpl(get()) }
}

val sessionUseCaseModule = module {
    factoryOf(::GetUserTokenUseCaseImpl) { bind<GetUserTokenUseCase>() }
    factoryOf(::SaveUserTokenUseCaseImpl) { bind<SaveUserTokenUseCase>() }
    factoryOf(::ClearSessionUseCaseImpl) { bind<ClearSessionUseCase>() }
}