package io.github.lumkit.krigin

import androidx.compose.ui.Alignment
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import io.github.lumkit.krigin.ui.KriginMain
import krigin.compose.generated.resources.Res
import krigin.compose.generated.resources.app_name
import krigin.compose.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

fun main() = application {
    val windowState = rememberWindowState(
        position = WindowPosition.Aligned(Alignment.Center),
    )
    Window(
        onCloseRequest = ::exitApplication,
        title = stringResource(Res.string.app_name),
        state = windowState,
        icon = painterResource(Res.drawable.compose_multiplatform)
    ) {
        KriginMain()
    }
}