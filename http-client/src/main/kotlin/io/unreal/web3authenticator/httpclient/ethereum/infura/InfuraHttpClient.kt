package io.unreal.web3authenticator.httpclient.ethereum.infura

import io.unreal.web3authenticator.httpclient.BasicHttpClient
import io.unreal.web3authenticator.httpclient.HttpClientSingleton

open class InfuraHttpClient(val infuraClientApiKey: String): BasicHttpClient(
    client = HttpClientSingleton.httpClient,
    baseUrl = "https://mainnet.infura.io"
) {
    val requestBuilder = InfuraRequestBuilder(
        id = InfuraApiSettings.id,
        jsonRPC = InfuraApiSettings.jsonRPC
    )

    override fun getUrl(): String {
        return "$baseUrl/v3/$infuraClientApiKey"
    }
}