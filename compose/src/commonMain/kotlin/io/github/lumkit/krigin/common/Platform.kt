package io.github.lumkit.krigin.common

enum class Platform {
    Android, IOS, Windows, MacOS, Linux, WasmJs, Other
}

expect fun currentPlatform(): Platform