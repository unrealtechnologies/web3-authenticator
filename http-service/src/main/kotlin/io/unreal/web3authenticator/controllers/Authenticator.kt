package io.unreal.web3authenticator.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

import io.unreal.web3authenticator.httpclient.Test
import io.unreal.web3authenticator.commons.objects.InfuraRequestBody

@RestController
class Authenticator {

    @GetMapping("/authenticate")
    fun authenticate(): String {

        val obj = InfuraRequestBody(
            jsonRpc = "rpc2.0",
            method = "letsdoit"
        )

        return obj.encodeToJsonString()
//        val test = Test()
//        return test.log()
    }
}