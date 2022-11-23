package io.unreal.web3authenticator.httpclient

import okhttp3.OkHttpClient

public object HttpClient {
    lateinit var httpClient: OkHttpClient

    init {
        val httpClient = OkHttpClient()
    }
}