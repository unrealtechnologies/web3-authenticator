package io.unreal.web3authenticator.httpclient

import okhttp3.OkHttpClient

open class BasicHttpClient(override val client: OkHttpClient, override val baseUrl: String) : HttpClientInterface {

}