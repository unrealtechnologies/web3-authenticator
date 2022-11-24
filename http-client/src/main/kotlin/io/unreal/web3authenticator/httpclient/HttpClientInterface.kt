package io.unreal.web3authenticator.httpclient

interface HttpClientInterface {
    fun getRequest() {}
    fun postRequest(body: Any) {}
}
