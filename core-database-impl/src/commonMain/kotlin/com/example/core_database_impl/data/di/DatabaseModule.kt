package com.example.core_database_impl.data.di

import com.example.core_database_api.data.repository.UserRepository
import com.example.core_database_api.data.usecase.GetUserByEmailUseCase
import com.example.core_database_api.data.usecase.GetUserByIdUseCase
import com.example.core_database_api.data.usecase.SaveUserUseCase
import com.example.core_database_impl.data.AppDatabase
import com.example.core_database_impl.data.RoomDatabaseFactory
import com.example.core_database_impl.data.createRoomDatabase
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
}

val databaseRepositoryModule = module {
    singleOf(::UserRepositoryImpl) { bind<UserRepository>() }
}

val databaseUseCaseModule = module {
    factoryOf(::GetUserByEmailUseCaseImpl) { bind<GetUserByEmailUseCase>() }
    factoryOf(::GetUserByIdUseCaseImpl) { bind<GetUserByIdUseCase>() }
    factoryOf(::SaveUserUseCaseImpl) { bind<SaveUserUseCase>() }
}