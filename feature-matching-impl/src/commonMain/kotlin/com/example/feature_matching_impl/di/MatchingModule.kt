package com.example.feature_matching_impl.di

import com.example.feature_matching_impl.screen.bottomsheet.BottomSheetViewModel
import com.example.feature_matching_impl.screen.mactching.MatchingViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val registrationModule = module {
    viewModelOf(::MatchingViewModel)
    viewModelOf(::BottomSheetViewModel)
    //factoryOf(::FeatureRegisterUserUseCaseImpl) { bind<FeatureRegistrationUseCase>() }
}
