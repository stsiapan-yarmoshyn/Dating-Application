package di

import com.example.core_database_impl.data.di.databaseModule
import com.example.core_database_impl.data.di.databaseRepositoryModule
import com.example.core_database_impl.data.di.databaseUseCaseModule
import com.example.core_database_impl.data.di.sessionModule
import com.example.core_database_impl.data.di.sessionUseCaseModule
import com.example.core_database_impl.data.session.platformDataStoreModule
import com.example.core_remote_impl.di.networkModule
import com.example.core_remote_impl.di.networkRepositoryModule
import com.example.core_remote_impl.di.networkUseCaseModule
import com.example.feature_login_impl.di.loginModule
import com.example.feature_matching_impl.di.matchingModule
import com.example.feature_registration_impl.di.registrationModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import viewmodel.MainViewModel

val shared = module {
    viewModelOf(::MainViewModel)
}
val appModules = listOf<Module>(
    shared,
    //Network
    networkModule, networkRepositoryModule, networkUseCaseModule,
    //Database
    databaseModule, databaseRepositoryModule, databaseUseCaseModule,
    //Feature
    registrationModule, matchingModule, loginModule,
    //Session
    sessionModule, sessionUseCaseModule, platformDataStoreModule
)

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(appModules)
    }
}