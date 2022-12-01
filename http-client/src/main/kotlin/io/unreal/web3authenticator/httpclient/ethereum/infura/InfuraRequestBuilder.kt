package io.unreal.web3authenticator.httpclient.ethereum.infura

import io.unreal.web3authenticator.commons.objects.InfuraRequestBody
import io.unreal.web3authenticator.commons.objects.InfuraMethods
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

class InfuraRequestBuilder(val jsonRPC: String, val id: Int) {
    fun build(method: InfuraMethods, params: List<Any>): RequestBody {
        val requestBody = InfuraRequestBody(
            id = method.methodPair.second,
            jsonRPC = jsonRPC,
            method = method.methodPair.first,
            params = params
        )

        return requestBody.jacksonSerializeToJsonString().toRequestBody("application/json".toMediaTypeOrNull())
    }
}
