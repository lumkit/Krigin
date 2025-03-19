package io.github.lumkit.krigin.mode

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.serialization.Serializable

@Serializable
class KriginThemeStore {
    var isSystemInDarkTheme: Boolean by mutableStateOf(false)
    var appDarkTheme by mutableStateOf(KriginThemeState.System)
    var realAppDarkTheme by mutableStateOf(
        when (appDarkTheme) {
            KriginThemeState.System -> isSystemInDarkTheme
            KriginThemeState.Light -> false
            KriginThemeState.Dark -> true
        }
    )
}
