package com.example.core_remote_impl.data.model.auth.payloads

import com.example.core_backendless_api.model.Payload
import com.example.core_remote_impl.data.model.auth.BackendlessRef
import com.google.gson.annotations.SerializedName

data class RelationPayload(
    @SerializedName("parentObject") val parentObject: BackendlessRef,
    @SerializedName("relationColumn") val relationColumn: String,
    @SerializedName("unconditional") val unconditional: BackendlessRef? = null,
    @SerializedName("unconditional") val unconditionalList: List<BackendlessRef>? = null,
): Payload
