package io.github.lumkit.krigin.common.json

import kotlinx.serialization.json.Json

val json by lazy {
    Json {
        prettyPrint = false
        ignoreUnknownKeys = true
        encodeDefaults = true
    }
}