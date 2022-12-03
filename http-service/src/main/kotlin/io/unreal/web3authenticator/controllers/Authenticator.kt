package io.unreal.web3authenticator.controllers

import io.unreal.web3authenticator.commons.objects.InfuraResponseBody
import io.unreal.web3authenticator.services.AuthenticatorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Authenticator(@Autowired val authenticatorService: AuthenticatorService) {
    @GetMapping("/authenticate")
    fun authenticate(blockHash: String): InfuraResponseBody {
        return authenticatorService.getBlockByHash(blockHash)
    }
}
