package com.example.feature_matching_impl.screen

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

@Preview(name = "light", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Target(AnnotationTarget.FUNCTION)
annotation class LightAndDarkPreview {
}