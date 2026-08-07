package com.example.core_database_impl.data.di

import com.example.core_database_api.data.repository.LocalMatchingRepository
import com.example.core_database_api.data.repository.LocalUserRepository
import com.example.core_database_api.data.usecase.user.GetUserByEmailUseCase
import com.example.core_database_api.data.usecase.user.GetUserByIdUseCase
import com.example.core_database_api.data.usecase.user.SaveUserUseCase
import com.example.core_database_impl.data.AppDatabase
import com.example.core_database_impl.data.RoomDatabaseFactory
import com.example.core_database_impl.data.createRoomDatabase
import com.example.core_database_impl.data.dao.UserDao
import com.example.core_database_impl.data.repository.MatchingRepositoryImpl
import com.example.core_database_impl.data.repository.UserRepositoryImpl
import com.example.core_database_impl.usecase.GetUserByEmailUseCaseImpl
import com.example.core_database_impl.usecase.GetUserByIdUseCaseImpl
import com.example.core_database_impl.usecase.SaveUserUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val databaseModule = module {

    single { RoomDatabaseFactory() }

    single<AppDatabase> {
        val factory: RoomDatabaseFactory  = get()
        createRoomDatabase(factory)
    }

    single { get<AppDatabase>().getUserDao() }
    single { get<AppDatabase>().getMatchingDao() }
}

val databaseRepositoryModule = module {
    singleOf(::UserRepositoryImpl) { bind<LocalUserRepository>() }
    singleOf(::MatchingRepositoryImpl) { bind<LocalMatchingRepository>() }
}

val databaseUseCaseModule = module {
    factoryOf(::GetUserByEmailUseCaseImpl) { bind<GetUserByEmailUseCase>() }
    factoryOf(::GetUserByIdUseCaseImpl) { bind<GetUserByIdUseCase>() }
    factoryOf(::SaveUserUseCaseImpl) { bind<SaveUserUseCase>() }
}