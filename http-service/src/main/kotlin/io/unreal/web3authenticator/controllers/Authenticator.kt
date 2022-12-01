package io.unreal.web3authenticator.controllers

import io.unreal.web3authenticator.commons.objects.InfuraResponseBody
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import io.unreal.web3authenticator.services.AuthenticatorService
import org.springframework.beans.factory.annotation.Autowired

@RestController
class Authenticator {

    @Autowired
    val authenticatorService = AuthenticatorService()

    @GetMapping("/authenticate")
    fun authenticate(): InfuraResponseBody {
        return authenticatorService.getBlockByHash("0xb3b20624f8f0f86eb50dd04688409e5cea4bd02d700bf6e79e9384d47d6a5a35")
    }
}