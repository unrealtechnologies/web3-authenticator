package io.unreal.web3authenticator.httpclient.ethereum.infura

import io.unreal.web3authenticator.commons.CommonsObject
import io.unreal.web3authenticator.commons.objects.InfuraMethods
import io.unreal.web3authenticator.commons.objects.InfuraRequestBody
import io.unreal.web3authenticator.commons.objects.InfuraResponseBody

fun InfuraHttpClient.getBlockInformationWithBlockNumber(blockHash: String, showTransactionDetails: Boolean): InfuraResponseBody {
    val res = postRequest(
        endpoint = this.getUrl(),
        body = InfuraRequestBody(
            id = InfuraMethods.GETBLOCKINFORMATIONBYNUMBER.methodPair.second,
            method = InfuraMethods.GETBLOCKINFORMATIONBYNUMBER.methodPair.first,
            jsonRPC = infuraClientSettings.jsonRPC,
            params = listOf(blockHash, showTransactionDetails)
        )
    )
    return CommonsObject.jacksonDeserializeFromJsonString<InfuraResponseBody>(res.body!!.string())
}
