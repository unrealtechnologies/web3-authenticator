package io.unreal.web3authenticator.httpclient

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

object HttpClientSingleton {
    val httpClient = OkHttpClient()
    fun execute(request: Request): Response = httpClient.newCall(request).execute()
}