package io.unreal.web3authenticator.controllers

import io.unreal.web3authenticator.commons.objects.InfuraResponseBody
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import io.unreal.web3authenticator.services.AuthenticatorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping("/block")
class BlockController {

    @Autowired
    val authenticatorService = AuthenticatorService()

    @GetMapping("/latest")
    fun authenticate(): InfuraResponseBody {
        return authenticatorService.getLatestBlockHash()
    }
}