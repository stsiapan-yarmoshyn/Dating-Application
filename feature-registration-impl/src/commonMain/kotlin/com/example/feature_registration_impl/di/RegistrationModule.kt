package com.example.feature_registration_impl.di

import com.example.feature_registration_api.usecase.FeatureRegistrationUseCase
import com.example.feature_registration_impl.data.usecase.FeatureRegisterUserUseCaseImpl
import com.example.feature_registration_impl.screen.RegistrationViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val registrationModule = module {
    viewModelOf(::RegistrationViewModel)
    factoryOf(::FeatureRegisterUserUseCaseImpl) { bind<FeatureRegistrationUseCase>() }
}
