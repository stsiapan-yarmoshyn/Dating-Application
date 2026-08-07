package com.example.feature_matching_impl.di

import com.example.feature_matching_api.usecase.FeatureGetUserByIdUseCase
import com.example.feature_matching_impl.data.usecase.FeatureGetUserByIdUseCaseImpl
import com.example.feature_matching_impl.screen.bottomsheet.BottomSheetViewModel
import com.example.feature_matching_impl.screen.mactching.MatchingViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val matchingModule = module {
    viewModelOf(::MatchingViewModel)
    viewModelOf(::BottomSheetViewModel)
    factoryOf(::FeatureGetUserByIdUseCaseImpl) { bind<FeatureGetUserByIdUseCase>() }
}
