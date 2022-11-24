package io.unreal.web3authenticator.commons.objects

import kotlinx.serialization.Serializable

@Serializable
data class InfuraRequestBody(
    val jsonRpc: String,
    val method: String,
)