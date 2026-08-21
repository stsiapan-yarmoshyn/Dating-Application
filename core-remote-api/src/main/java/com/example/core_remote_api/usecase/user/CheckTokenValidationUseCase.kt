package com.example.core_remote_api.usecase.user

interface CheckTokenValidationUseCase {

    suspend operator fun invoke(): Result<Boolean>
}