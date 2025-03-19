package io.github.lumkit.krigin.common.protobuf

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.protobuf.ProtoBuf

@OptIn(ExperimentalSerializationApi::class)
val protobuf by lazy {
    ProtoBuf {
        encodeDefaults = true
    }
}