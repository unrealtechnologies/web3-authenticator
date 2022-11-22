package io.unreal.web3authenticator.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Authenticator {

    @GetMapping("/authenticate")
    fun authenticate(): String {
        return "Simple authenticate endpoint"
    }
}