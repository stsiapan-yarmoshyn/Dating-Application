package com.example.core_remote_impl.data.model.auth

import com.google.gson.annotations.SerializedName

data class TransactionRequest(
    @SerializedName("operations") val operations: List<TransactionOperation>,
)
