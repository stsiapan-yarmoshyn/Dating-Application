package di

import com.example.core_database_impl.data.di.databaseModule
import com.example.core_database_impl.data.di.databaseRepositoryModule
import com.example.core_database_impl.data.di.databaseUseCaseModule
import com.example.core_remote_impl.di.networkModule
import com.example.core_remote_impl.di.networkRepositoryModule
import com.example.core_remote_impl.di.networkUseCaseModule
import com.example.feature_matching_impl.di.matchingModule
import com.example.feature_registration_impl.di.registrationModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration

val appModules = listOf<Module>(
    //Network
    networkModule, networkRepositoryModule, networkUseCaseModule,
    //Database
    databaseModule, databaseRepositoryModule, databaseUseCaseModule,
    //Feature
    registrationModule, matchingModule
)

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(appModules)
    }
}