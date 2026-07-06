package com.example.feature_matching_impl.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_matching_impl.data.usecase.GetMatchingUserUseCase
import com.example.feature_matching_impl.screen.ui.user
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchingViewModel @Inject constructor(
    private val getUserUseCase: GetMatchingUserUseCase,
//    private val locationTracker: LocationTracker
) : ViewModel() {

    private val _state = MutableStateFlow(MatchingScreenUiState())
    val state = _state.asStateFlow()

    private val pageSize = 20
    private var currentPage = 0
    private val prefetchThreshold = 5

    fun handleEvent(event: MatchingEvent) {
        when (event) {
            is MatchingEvent.LoadNextPage -> { loadNextPage() }

            is MatchingEvent.OnCardSwiped -> {  }
        }
    }

    private fun loadNextPage() {
        if (_state.value.isPageLoading) return

        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(isPageLoading = true) }

            val location = locationTracker.getCurrentLocation()

            val result = getUserUseCase("")
            result.onSuccess { user ->
                _state.update {
                    it.copy(
                        users = it.users + user,
                        isPageLoading = false
                    )
                }
                currentPage++
            }.onFailure { error ->
                _state.update {
                    it.copy(isPageLoading = false, error = error.localizedMessage)
                }
            }
        }
    }

    private fun onCardSwiped(isLiked: Boolean) {
        if (isLiked) {

        } else {
            _state.update { currentState ->
                val updatedUsers = currentState.users.drop(1)

                if (updatedUsers.size <= prefetchThreshold) {
                    loadNextPage()
                }

                currentState.copy(users = updatedUsers)
            }
        }

    }
}