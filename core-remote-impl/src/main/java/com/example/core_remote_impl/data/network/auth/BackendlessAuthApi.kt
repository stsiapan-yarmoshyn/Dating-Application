package com.example.core_remote_impl.data.network.auth

import com.example.core_remote_impl.data.model.auth.TransactionRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface BackendlessAuthApi {

    @POST("api/transaction/unit-of-work")
    suspend fun executeTransaction(
        @Body request: TransactionRequest
    ): Result<Any> //TODO replace to normal type


}