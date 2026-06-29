package com.example.core_backendless_api.usecase.user

interface DeleteUserUseCase {

    suspend operator fun invoke(userId: String)

}