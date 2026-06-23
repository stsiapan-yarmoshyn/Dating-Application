package com.example.core_remote_impl.data.model.auth

import com.example.core_backendless_api.model.Payload
import com.google.gson.annotations.SerializedName

data class TransactionOperation(
    @SerializedName("operationType") val operationType: String,
    @SerializedName("table") val table: String,
    @SerializedName("opResultId") val opResultId: String? = null,
    @SerializedName("payload") val payload: Payload,
) {
    companion object {
        const val OPERATION_TYPE_CREATE = "CREATE"
        const val OPERATION_TYPE_SET_RELATION = "SET_RELATION"
    }
}