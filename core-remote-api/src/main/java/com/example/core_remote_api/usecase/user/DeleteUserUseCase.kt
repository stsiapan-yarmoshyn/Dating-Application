package com.example.core_remote_api.usecase.user

interface DeleteUserUseCase {

    suspend operator fun invoke(userId: String)

}