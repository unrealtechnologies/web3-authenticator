package io.unreal.web3authenticator.httpclient.ethereum.infura

class InfuraApi(val infuraClientApiKey: String)  {
    val settings = InfuraApiSettings
    val blockApi: BlockApi = BlockApi(infuraClientApiKey)
}