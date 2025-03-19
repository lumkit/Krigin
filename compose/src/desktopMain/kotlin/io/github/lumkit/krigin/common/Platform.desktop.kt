package io.github.lumkit.krigin.common

import org.jetbrains.skiko.hostOs

actual fun currentPlatform(): Platform = when (hostOs) {
    org.jetbrains.skiko.OS.Linux -> Platform.Linux
    org.jetbrains.skiko.OS.Windows -> Platform.Windows
    org.jetbrains.skiko.OS.MacOS -> Platform.MacOS
    else -> Platform.Other
}