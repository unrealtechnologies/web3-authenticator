package io.unreal.web3authenticator.httpclient

import io.unreal.web3authenticator.commons.errors.HttpRequestFailedException
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response

interface HttpClientInterface {
    val client: OkHttpClient
    val baseUrl: String

    fun getUrl(): String {
        return ""
    }
    fun getUrl(endpoint: String): String {
        return baseUrl + endpoint
    }
    fun getRequest(endpoint: String): Response {
        val req = requestBuilder(
            url = getUrl(endpoint),
            body = null
        )

        return retrieveResponse(req)
    }

    fun postRequest(endpoint: String, body: RequestBody): Response {
        val req = requestBuilder(
            url = getUrl(endpoint),
            body = body
        )
        return retrieveResponse(req)
    }

    fun requestBuilder(url: String, body: RequestBody?): Request {
        val req = Request.Builder().url(url)

        if (body != null) {
            req.post(body)
        }

        return req.build()
    }

    @Throws(HttpRequestFailedException::class)
    fun retrieveResponse(req: Request): Response {
        val res = client.newCall(req).execute()
        require(res.isSuccessful) {
            throw HttpRequestFailedException("Request was not made successfully downstream service returned ${res.code}")
        }
        return client.newCall(req).execute()
    }
}
