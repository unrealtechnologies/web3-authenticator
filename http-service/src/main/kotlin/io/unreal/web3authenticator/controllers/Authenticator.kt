package io.unreal.web3authenticator.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import io.unreal.web3authenticator.httpclient.ethereum.infura.InfuraApi
import io.unreal.web3authenticator.services.AuthenticatorService
import org.springframework.beans.factory.annotation.Autowired


@RestController
class Authenticator {

    @Autowired
    val authenticatorService = AuthenticatorService()

    @GetMapping("/authenticate")
    fun authenticate(): String {
        return authenticatorService.getBlockByHash()
    }
}