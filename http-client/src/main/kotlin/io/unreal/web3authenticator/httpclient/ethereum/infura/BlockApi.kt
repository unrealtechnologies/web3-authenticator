package io.unreal.web3authenticator.httpclient.ethereum.infura

import io.unreal.web3authenticator.commons.CommonsObject
import io.unreal.web3authenticator.commons.objects.InfuraResponseBody

class BlockApi(infuraClientApiKey: String): InfuraHttpClient(infuraClientApiKey = infuraClientApiKey) {
    fun getBlockByHash(blockHash: String, showTransactionDetails: Boolean): InfuraResponseBody {
        val body = requestBuilder.build(
            method = InfuraMethods.GETBLOCKHASH,
            params = listOf(blockHash, showTransactionDetails)
        )

        val req = requestBuilder(
            url = getUrl(),
            body = body
        )

        val res = retrieveResponse(req)
        return CommonsObject.jacksonDeserializeFromJsonString<InfuraResponseBody>(res.body!!.string())
    }

    fun getLatestBlock(): InfuraResponseBody {
        val body = requestBuilder.build(
            method = InfuraMethods.GETLATESTBLOCKNUMBER,
            params = listOf()
        )

        val req = requestBuilder(
            url = getUrl(),
            body = body
        )

        val res = retrieveResponse(req)
        return CommonsObject.jacksonDeserializeFromJsonString<InfuraResponseBody>(res.body!!.string())
    }
}