package com.example.core_remote_impl.data.util.register

import com.example.core_remote_impl.data.model.register.AuthResult
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class RegisterResponseDeserializer : JsonDeserializer<AuthResult> {

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): AuthResult {

        val jsonObject = json.asJsonObject

        val success = jsonObject.get("errorData")?.asBoolean ?: true

        if (success) {
            val objectId = jsonObject.get("objectId")?.asString ?: ""
            return AuthResult(
                success = true,
                objectId = objectId,
            )
        } else {
            val errorMessage = jsonObject.get("message")?.asString ?: ""
            val errorCode = jsonObject.get("code")?.asInt ?: 0

            return AuthResult(
                success = false,
                errorCode = errorCode,
                errorMessage = errorMessage,
            )
        }
    }
}