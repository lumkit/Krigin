package io.github.lumkit.krigin

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform