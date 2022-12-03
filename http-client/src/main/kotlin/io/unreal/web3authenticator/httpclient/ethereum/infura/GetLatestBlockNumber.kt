package io.unreal.web3authenticator.httpclient.ethereum.infura

import io.unreal.web3authenticator.commons.CommonsObject
import io.unreal.web3authenticator.commons.objects.InfuraMethods
import io.unreal.web3authenticator.commons.objects.InfuraRequestBody
import io.unreal.web3authenticator.commons.objects.InfuraResponseBody

fun InfuraHttpClient.getLatestBlockNumber(): InfuraResponseBody {
    val res = postRequest(
        endpoint = this.getUrl(),
        body = InfuraRequestBody(
            id = InfuraMethods.GETLATESTBLOCKNUMBER.methodPair.second,
            method = InfuraMethods.GETLATESTBLOCKNUMBER.methodPair.first,
            jsonRPC = infuraClientSettings.jsonRPC,
            params = emptyList()
        )
    )
    return CommonsObject.jacksonDeserializeFromJsonString<InfuraResponseBody>(res.body!!.string())
}
