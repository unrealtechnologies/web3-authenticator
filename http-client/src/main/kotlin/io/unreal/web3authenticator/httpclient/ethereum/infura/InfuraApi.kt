package io.unreal.web3authenticator.httpclient.ethereum.infura

open class InfuraApi(private val infuraClientApiKey: String, private val baseUrl: String)  {
    val settings = InfuraApiSettings
    val blockApi: BlockApi = BlockApi(infuraClientApiKey, baseUrl)
}