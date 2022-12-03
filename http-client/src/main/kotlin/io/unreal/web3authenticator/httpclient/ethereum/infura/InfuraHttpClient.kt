package io.unreal.web3authenticator.httpclient.ethereum.infura

import io.unreal.web3authenticator.httpclient.HttpClientInterface

open class InfuraHttpClient(val infuraClientSettings: InfuraClientSettings) : HttpClientInterface(baseUrl = infuraClientSettings.baseUrl) {
    override fun getUrl(): String {
        return "$baseUrl/v3/${infuraClientSettings.apiKey}"
    }
}
