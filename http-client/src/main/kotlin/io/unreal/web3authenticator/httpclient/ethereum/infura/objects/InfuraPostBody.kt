package io.unreal.web3authenticator.httpclient.ethereum.infura.objects

data class InfuraPostBody(
    val JsonRPC: String,
    val method: String,
    val Params: Any
)