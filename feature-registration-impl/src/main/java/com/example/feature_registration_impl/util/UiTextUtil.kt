package com.example.feature_registration_impl.util

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

//Возможно вынести в отдельный модуль utils
sealed class UiTextUtil {

    data class DynamicString(val text: String): UiTextUtil()
    class StringResource(@StringRes val resId: Int, vararg val args: Any): UiTextUtil()

    @Composable
    fun AsString() {
        when(this) {
            is DynamicString -> text
            is StringResource -> stringResource(resId, *args)
        }
    }

}