package com.example.feature_registration_impl.util

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.getString
import org.jetbrains.compose.resources.stringResource

//Возможно вынести в отдельный модуль utils
sealed class UiTextUtil {

    data class DynamicString(val text: String): UiTextUtil()

    class StringResourceKmp(
        val resource: StringResource,
        vararg val args: Any
    ) : UiTextUtil()

    /**
     * Used for providing strings in composables
     * */
    @Composable
    fun asString(): String {
        return when (this) {
            is DynamicString -> text
            is StringResourceKmp -> stringResource(resource, *args)
        }
    }
    /**
     * Used for providing strings in suspend code
     * */
    suspend fun asStringSuspend(): String {
        return when (this) {
            is DynamicString -> text
            is StringResourceKmp -> {
                getString(resource, *args)
            }
        }
    }

}