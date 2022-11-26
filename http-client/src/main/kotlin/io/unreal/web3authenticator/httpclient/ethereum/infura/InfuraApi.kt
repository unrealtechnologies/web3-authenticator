package io.unreal.web3authenticator.httpclient.ethereum.infura

class InfuraApi(val infuraClientApiKey: String)  {
//    init {
//        infuraApiSettings.rpc = ""
//    }

    val blockApi: BlockApi = BlockApi(infuraClientApiKey)
}