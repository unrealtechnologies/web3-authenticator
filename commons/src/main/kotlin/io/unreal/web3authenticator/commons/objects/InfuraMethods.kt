package io.unreal.web3authenticator.httpclient.ethereum.infura

enum class InfuraMethods(val methodPair: Pair<String, String>) {
    GETBLOCKHASH(Pair("eth_getBlockByHash", "1")),
    GETLATESTBLOCKNUMBER(Pair("eth_blockNumber", "2"))
}