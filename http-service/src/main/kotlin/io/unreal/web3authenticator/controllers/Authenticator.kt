package io.unreal.web3authenticator.controllers

import io.unreal.web3authenticator.commons.objects.BlockInformation
import io.unreal.web3authenticator.commons.objects.InfuraResponseBody
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import io.unreal.web3authenticator.httpclient.ethereum.infura.InfuraApi
import io.unreal.web3authenticator.httpclient.ethereum.infura.InfuraMethods
import io.unreal.web3authenticator.services.AuthenticatorService
import org.springframework.beans.factory.annotation.Autowired
import kotlin.reflect.typeOf


@RestController
class Authenticator {

    @Autowired
    val authenticatorService = AuthenticatorService()

    @GetMapping("/authenticate")
    fun authenticate(): InfuraResponseBody {
//        val block = authenticatorService.getBlockByHash().result
//        println(block as BlockInformation)
        val block = authenticatorService.getBlockByHash().result
        return authenticatorService.getBlockByHash()
    }
}