package com.example.core_remote_impl.di

import com.example.core_remote_api.repository.RemotePhotoRepository
import com.example.core_remote_api.repository.RemoteUserRepository
import com.example.core_remote_api.usecase.photo.AppendPhotosUseCase
import com.example.core_remote_api.usecase.photo.DeletePhotosUseCase
import com.example.core_remote_api.usecase.photo.GetPhotosUseCase
import com.example.core_remote_api.usecase.user.AuthenticateUserUseCase
import com.example.core_remote_api.usecase.user.DeleteUserUseCase
import com.example.core_remote_api.usecase.user.GetMatchingUsersUseCase
import com.example.core_remote_api.usecase.user.RegisterUserUseCase
import com.example.core_remote_impl.BuildKonfig
import com.example.core_remote_impl.data.network.PhotoApi
import com.example.core_remote_impl.data.network.UserServiceApi
import com.example.core_remote_impl.data.network.createKtorClient
import com.example.core_remote_impl.data.repository.PhotoRepositoryImpl
import com.example.core_remote_impl.data.repository.UserRepositoryImpl
import com.example.core_remote_impl.usecase.photo.AppendPhotosUseCaseImpl
import com.example.core_remote_impl.usecase.photo.DeletePhotosUseCaseImpl
import com.example.core_remote_impl.usecase.photo.GetPhotosUseCaseImpl
import com.example.core_remote_impl.usecase.user.AuthenticateUserUseCaseImpl
import com.example.core_remote_impl.usecase.user.DeleteUserUseCaseImpl
import com.example.core_remote_impl.usecase.user.GetMatchingUsersUseCaseImpl
import com.example.core_remote_impl.usecase.user.RegisterUserUseCaseImpl
import io.ktor.client.engine.cio.CIO.create
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkModule = module {

    single<UserServiceApi> {
        val client = createKtorClient(create())
        UserServiceApi(client)
    }

    single<PhotoApi> {
        val client = createKtorClient(create())
        PhotoApi(client, baseUrl = BuildKonfig.BACKENDLESS_BASE_URL)
    }

}

// ---- Repositories ----
val networkRepositoryModule = module {
    // get() подставится автоматически для UserServiceApi/PhotoApi
    singleOf(::UserRepositoryImpl) { bind<RemoteUserRepository>() }
    singleOf(::PhotoRepositoryImpl) { bind<RemotePhotoRepository>() }
}

// ---- Use Cases ----
val networkUseCaseModule = module {
    factoryOf(::AuthenticateUserUseCaseImpl) { bind<AuthenticateUserUseCase>() }
    factoryOf(::RegisterUserUseCaseImpl) { bind<RegisterUserUseCase>() }
    factoryOf(::DeleteUserUseCaseImpl) { bind<DeleteUserUseCase>() }
    factoryOf(::GetMatchingUsersUseCaseImpl) { bind<GetMatchingUsersUseCase>() }

    factoryOf(::AppendPhotosUseCaseImpl) { bind<AppendPhotosUseCase>() }
    factoryOf(::DeletePhotosUseCaseImpl) { bind<DeletePhotosUseCase>() }
    factoryOf(::GetPhotosUseCaseImpl) { bind<GetPhotosUseCase>() }
}