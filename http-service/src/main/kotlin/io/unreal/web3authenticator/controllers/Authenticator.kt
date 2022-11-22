package io.unreal.web3authenticator.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

import io.unreal.web3authenticator.httpclient.Test

@RestController
class Authenticator {

    @GetMapping("/authenticate")
    fun authenticate(): String {
        val test = Test()
        return test.log()
    }
}