package com.example.feature_matching_impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.feature_matching_api.navigation.MatchingRoute
import com.example.feature_matching_impl.screen.bottomsheet.BottomSheetViewModel
import com.example.feature_matching_impl.screen.bottomsheet.ui.bottom_sheet.UserBottomSheet
import com.example.feature_matching_impl.screen.mactching.MatchingViewModel
import com.example.feature_matching_impl.screen.mactching.ui.MatchingScreen
import org.koin.compose.viewmodel.koinViewModel

fun EntryProviderScope<NavKey>.matchingGraph(
    backStack: NavBackStack<NavKey>,
    navigateToChat: (String) -> Unit,
    navigateToProfile: (String) -> Unit,
    navigateToMatching: () -> Unit,
) {
    entry<MatchingRoute.Main> {
        val viewModel = koinViewModel<MatchingViewModel>()
        MatchingScreen(matchingViewModel = viewModel,
            navigateToDetails = { id ->
                backStack.add(MatchingRoute.Details(id))
            },
            navigateToChat = navigateToChat,
            navigateToProfile = navigateToProfile,
            navigateToMatching = navigateToMatching
        )
    }

    entry<MatchingRoute.Details> {
        val viewModel = koinViewModel<BottomSheetViewModel>()
        UserBottomSheet(bottomSheetViewModel = viewModel)
    }
}