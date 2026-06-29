package com.example.feature_registration_impl.util

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

//Возможно вынести в отдельный модуль utils
sealed class UiTextUtil {

    data class DynamicString(val text: String): UiTextUtil()
    class StringResource(@StringRes val resId: Int, vararg val args: Any): UiTextUtil()

    /**
     * Used for providing strings in composables
     * */
    @Composable
    fun asString(): String {
        return when(this) {
            is DynamicString -> text
            is StringResource -> stringResource(resId, *args)
        }
    }
    /**
     * Used for providing strings in default code
     * */
    fun asString(context: Context): String {
        return when(this) {
            is DynamicString -> text
            is StringResource -> context.getString(resId, *args)
        }
    }

}