package io.unreal.web3authenticator.services

import io.unreal.web3authenticator.httpclient.ethereum.infura.InfuraApi
import org.springframework.stereotype.Service

@Service
class AuthenticatorService {
    fun getBlockByHash(): String {
        val infuraApi = InfuraApi("")
        return infuraApi.blockApi.getBlockByHash("0xb3b20624f8f0f86eb50dd04688409e5cea4bd02d700bf6e79e9384d47d6a5a35", false)
    }
}