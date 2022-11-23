package io.unreal.web3authenticator.httpclient

import okhttp3.Request

open class HttpClientBase {
    private val client = HttpClient

    fun request(): Request.Builder {
        return Request.Builder()
    }

    fun get() {
        client.httpClient
    }

    fun post(body: Any) {
        val req = this.request()
        req.addHeader("Content-Type", "application/json")
        req.post(body)
    }
}
