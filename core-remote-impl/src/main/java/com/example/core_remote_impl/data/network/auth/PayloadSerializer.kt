package com.example.core_remote_impl.data.network.auth

import com.example.core_backendless_api.model.Payload
import com.google.gson.JsonElement
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type

class PayloadSerializer: JsonSerializer<Payload> {
    override fun serialize(
        src: Payload?,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement? {
        return context?.serialize(src, src?.javaClass)
    }

}