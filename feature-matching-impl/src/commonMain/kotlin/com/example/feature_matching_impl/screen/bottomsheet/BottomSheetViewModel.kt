package com.example.feature_matching_impl.screen.bottomsheet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_matching_api.usecase.FeatureGetUserByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BottomSheetViewModel(
    private val getUserByIdUseCase: FeatureGetUserByIdUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(BottomSheetState())
    val state: StateFlow<BottomSheetState> = _state.asStateFlow()

    fun handleIntent(
        event: BottomSheetEvent
    ) {
        when (event) {
            is BottomSheetEvent.OnShowBottomSheet -> {
                onShowBottomSheet()
            }

            is BottomSheetEvent.OnCloseBottomSheet -> {
                onCloseBottomSheet()
            }

            is BottomSheetEvent.ShowUserData -> {
                showUserData(userId = event.userId)
            }
        }
    }

    private fun onCloseBottomSheet() {
        _state.update {
            it.copy(isBottomSheetOpen = false)
        }
    }

    private fun onShowBottomSheet() {
        _state.update {
            it.copy(isBottomSheetOpen = true)
        }
    }

    private fun showUserData(userId: String) {
        //sent dispatcher higher
        viewModelScope.launch {
            getUserByIdUseCase(userId)
                .onSuccess { user ->
                    _state.update {
                        it.copy(
                            userName = user.name,
                            userBio = user.bio,
                            userPhotos = user.photos
                        )
                    }
                }
                .onFailure {
                    //TODO handle error
                }
        }
    }

}