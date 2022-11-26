package io.unreal.web3authenticator.httpclient.ethereum.infura

import io.unreal.web3authenticator.httpclient.BasicHttpClient
import io.unreal.web3authenticator.httpclient.HttpClientSingleton

// https://mainnet.infura.io/v3/f4a33b53695443739067c53f6b89a5e2
class InfuraClient(infuraClientApiKey: String): BasicHttpClient(
    client = HttpClientSingleton.httpClient,
    baseUrl = "https://mainnet.infura.io"
) {
    override fun getUrl(endpoint: String): String {
        return super.getUrl("v3/$endpoint")
    }
}