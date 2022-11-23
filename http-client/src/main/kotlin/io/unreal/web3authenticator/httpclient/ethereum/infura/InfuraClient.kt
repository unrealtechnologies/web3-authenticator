package io.unreal.web3authenticator.httpclient.ethereum.infura

import io.unreal.web3authenticator.httpclient.HttpClientBase

class InfuraClient(infuraClientApiKey: String): HttpClientBase() {

    fun requestBlock(blockHash: String) {
        this.request("")
    }

}