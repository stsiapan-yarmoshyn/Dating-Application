package com.example.core_remote_impl.data.util.auth

import com.example.core_remote_impl.data.model.auth.AuthResult
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class AuthResponseDeserializer: JsonDeserializer<AuthResult> {

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): AuthResult {
        val jsonObject = json.asJsonObject

        val success = jsonObject.get("success")?.asBoolean ?: false

        if (success) {
            val resultArray = jsonObject.getAsJsonArray("results")

            if (resultArray != null && resultArray.size() > 0) {
                for (element in resultArray) {
                    val opObject = element.asJsonObject
                    if (opObject.has("opResultId") && opObject.get("opResultId").asString == "newUserResult") {
                        val resultData = opObject.getAsJsonObject("result")
                        val objectId = resultData?.get("objectId")?.asString
                        return AuthResult(success = true, objectId = objectId)}
                }
            }
            return AuthResult(success = false)
        } else {
            val errorObject = jsonObject.getAsJsonObject("error")
            val errorCode = errorObject?.get("code")?.asInt
            val errorMessage = errorObject?.get("message")?.asString

            return AuthResult(
                success = false,
                errorCode = errorCode,
                errorMessage = errorMessage
            )
        }
    }
}