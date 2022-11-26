//package io.unreal.web3authenticator.httpclient
//
//import okhttp3.FormBody
//import okhttp3.Request
//import okhttp3.RequestBody
//import okhttp3.Response
//import kotlin.reflect.typeOf
//
//open class HttpClientBase(override val baseUrl: String): HttpClientInterface {
//    override val client = HttpClientSingleton.httpClient
//
//
//    fun request(): Request.Builder {
//        return Request.Builder()
//            .url(baseUrl)
//    }
//
////    override fun getRequest(endpoint: String): Response {
//////        client
////    }
////
////    override fun postRequest(endpoint: String, body: RequestBody): Response {
////        val req = this.request()
////        req.addHeader("Content-Type", "application/json")
////    }
//
////    fun postForm(body: FormBody) {
////        val req = this.request().post(body).build()
////    }
////
////    fun internalCall(req: Request) {
////        val call = client.newCall(req)
////    }
//}
