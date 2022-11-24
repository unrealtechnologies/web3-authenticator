package io.unreal.web3authenticator.httpclient

import okhttp3.FormBody
import okhttp3.Request
import kotlin.reflect.typeOf

open class HttpClientBase(val baseUrl: String): HttpClientInterface {
    private val client = HttpClientSingleton.httpClient


    fun request(): Request.Builder {
        return Request.Builder()
            .url(baseUrl)
    }

    override fun getRequest() {
//        client
    }

    override fun postRequest(body: Any) {
        val req = this.request()
        req.addHeader("Content-Type", "application/json")
    }

    fun postForm(body: FormBody) {
        val req = this.request().post(body).build()
    }

    fun internalCall(req: Request) {
        val call = client.newCall(req)
    }
}
