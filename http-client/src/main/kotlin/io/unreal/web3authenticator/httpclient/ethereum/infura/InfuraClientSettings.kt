package io.unreal.web3authenticator.httpclient.ethereum.infura

data class InfuraClientSettings(
    val id: Int,
    val jsonRPC: String,
    val baseUrl: String,
    val apiKey: String
)
