package io.unreal.web3authenticator.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import io.unreal.web3authenticator.httpclient.ethereum.infura.InfuraApi


@RestController
class Authenticator {

    @GetMapping("/authenticate")
    fun authenticate(): String {
        val infuraApi = InfuraApi("")
        return infuraApi.blockApi.getBlockByHash("0xb3b20624f8f0f86eb50dd04688409e5cea4bd02d700bf6e79e9384d47d6a5a35", false)
    }
}