package io.github.lumkit.krigin.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.*
import io.github.lumkit.krigin.common.Platform
import io.github.lumkit.krigin.common.currentPlatform
import io.github.lumkit.krigin.ui.LocalKriginThemeStore
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.datetime.Clock

@Composable
fun KriginTheme(content: @Composable () -> Unit) {
    UpdateSystemInDarkTheme()


}

@Composable
private fun UpdateSystemInDarkTheme() {
    val platform = currentPlatform()
    val kriginThemeStore = LocalKriginThemeStore.current
    when (platform) {
        Platform.Windows, Platform.MacOS, Platform.Linux, Platform.WasmJs, Platform.IOS -> {
            var updateKey by remember { mutableStateOf(0L) }

            LaunchedEffect(updateKey) {
                delay(2000)
                updateKey = Clock.System.now().toEpochMilliseconds()
            }

            kriginThemeStore.isSystemInDarkTheme = isSystemInDarkTheme()
        }
        else -> Unit
    }
}
