package io.github.lumkit.krigin

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.github.lumkit.krigin.ui.KriginMain

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Krigin",
    ) {
        KriginMain()
    }
}