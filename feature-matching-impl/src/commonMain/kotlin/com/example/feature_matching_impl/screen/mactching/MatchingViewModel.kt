package com.example.feature_matching_impl.screen.mactching

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_remote_api.usecase.user.GetMatchingUsersUseCase
import com.example.feature_matching_api.model.PhotoModel
import com.example.feature_matching_api.model.UserProfileModel
import com.example.feature_matching_impl.screen.SwipeDirection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

//TODO -> delete mock data
//mock user 1
val user = UserProfileModel(
    userId = "0",
    name = "Sarah, 24",
    gender = "",
    email = "sara@fff",
    bio = "UI/UX Designer who runs on iced matchas and design deadlines. When I am not pushing pixels, I am exploring hiking trails or cataloging thrift stores.",
    birthDate = 0,
    photos = listOf(
        PhotoModel("", 0),
        PhotoModel("", 1),
        PhotoModel("", 2)
    ),
    searchGender = ""
)

//Mock user 2
val user2 = UserProfileModel(
    userId = "1",
    name = "Maks, 24",
    gender = "",
    email = "Maks@ggg",
    bio = "When I am not pushing pixels, I am exploring hiking trails or cataloging thrift stores.",
    birthDate = 0,
    photos = listOf(
        PhotoModel("", 0),
        PhotoModel("", 1),
        PhotoModel("", 2)
    ),
    searchGender = ""
)

//Mock user 3
val user3 = UserProfileModel(
    userId = "3",
    name = "Eugene, 24",
    gender = "",
    email = "Eugene@jjj",
    bio = "Test test test tes.",
    birthDate = 0,
    photos = listOf(
        PhotoModel("", 0),
        PhotoModel("", 1),
        PhotoModel("", 2)
    ),
    searchGender = ""
)

val userL = listOf(user3, user2, user)

class MatchingViewModel(
    private val getMatchingUserUseCase: GetMatchingUsersUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(MatchingScreenUiState())
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<SwipeDirection>()
    val effect: SharedFlow<SwipeDirection> = _effect

    fun handleEvent(event: MatchingEvent) {
        when (event) {
            is MatchingEvent.LoadNextPage -> { loadNextPage() }

            is MatchingEvent.OnSwipeLeft -> {
                onLeftSwipe()
            }
            is MatchingEvent.OnSwipeRight -> {
                onRightSwipe()
            }

            is MatchingEvent.HandleUser -> {
                handleUser(event.currentUser, event.isLiked)
            }
        }
    }

    private fun loadNextPage() {
        if (_state.value.isPageLoading) return

        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(isPageLoading = true) }

            _state.update {
                it.copy(
                    users = userL,
                    isPageLoading = false
                )
            }

            //val location = locationTracker.getCurrentLocation()

//            val result = getMatchingUserUseCase(
//                "",
//                DEFAULT_PAGE_SIZE,
//                START_OFFSET
//            )
//            result.onSuccess { user ->
//                _state.update {
//                    it.copy(
//                        users = userL,
//                        isPageLoading = false
//                    )
//                }
//                currentPage++
//            }.onFailure { error ->
//                _state.update {
//                    it.copy(isPageLoading = false, error = error.localizedMessage)
//                }
//            }
        }
    }

    private fun onLeftSwipe() {
        viewModelScope.launch {
            _effect.emit(SwipeDirection.Left)
        }
    }

    private fun onRightSwipe() {
        viewModelScope.launch {
            _effect.emit(SwipeDirection.Right)
        }
    }

    private fun handleUser(user: UserProfileModel, isLiked: Boolean){
        if (isLiked) {
            //TODO
        }
        _state.update { currentState ->
            val updatedUsers = currentState.users.drop(1)

            if (updatedUsers.size <= PREFETCH_THRESHOLD) {
                loadNextPage()
            }

            currentState.copy(users = updatedUsers)
        }
    }
    companion object {
        const val DEFAULT_PAGE_SIZE = 10
        const val START_OFFSET = 0

        const val PREFETCH_THRESHOLD = 5
    }
}