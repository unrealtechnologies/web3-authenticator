package io.unreal.web3authenticator.commons.objects

import io.unreal.web3authenticator.commons.ObjectInterface
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class InfuraRequestBody(
    val jsonRpc: String,
    val method: String,
)