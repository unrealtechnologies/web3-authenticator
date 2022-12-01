package io.unreal.web3authenticator.httpclient

import okhttp3.OkHttpClient

object HttpClientSingleton {
    val httpClient = OkHttpClient()
}