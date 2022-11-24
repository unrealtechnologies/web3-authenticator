package io.unreal.web3authenticator.commons

data class InfuraPostBody(
    val JsonRPC: String,
    val method: String,
    val Params: Any
)