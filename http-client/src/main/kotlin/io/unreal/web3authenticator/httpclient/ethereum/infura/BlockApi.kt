package io.unreal.web3authenticator.httpclient.ethereum.infura

import io.unreal.web3authenticator.commons.CommonsObject
import io.unreal.web3authenticator.commons.objects.BlockHash
import io.unreal.web3authenticator.commons.objects.BlockInformation
import io.unreal.web3authenticator.commons.objects.InfuraResponseBody
import io.unreal.web3authenticator.commons.objects.InfuraResult
import kotlin.reflect.typeOf

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

        val infuraResponse = CommonsObject.jacksonDeserializeFromJsonString<InfuraResponseBody>(res.body!!.string())

//        println(infuraResponse.result is BlockApi)
        println(infuraResponse.result is InfuraResult)
        println(infuraResponse.result is BlockHash)
        println(infuraResponse.result is BlockInformation)

//        println(CommonsObject.jacksonDeserializeFromJsonString<InfuraResponseBody>(res.body!!.string()))

        return infuraResponse
    }
}