package io.unreal.web3authenticator.services

import io.unreal.web3authenticator.YMLConfig
import io.unreal.web3authenticator.commons.objects.BlockHash
import io.unreal.web3authenticator.commons.objects.BlockInformation
import io.unreal.web3authenticator.commons.objects.InfuraResponseBody
import io.unreal.web3authenticator.httpclient.ethereum.infura.InfuraApi
import io.unreal.web3authenticator.objects.BlockObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AuthenticatorService(@Autowired val ymlConfig: YMLConfig) {

    val infuraApi = InfuraApi(
        baseUrl = ymlConfig.httpClients["infura"]!!.baseUrl,
        infuraClientApiKey = ymlConfig.httpClients["infura"]!!.apiKey
    )

    fun getBlockByHash(hash: String): InfuraResponseBody {
        return infuraApi.blockApi.getBlockByHash(hash, false)
    }

    fun getLatestBlockHash(): InfuraResponseBody {
        return infuraApi.blockApi.getLatestBlock()
    }

    fun getBlockByBlockNumber(blockNumber: String): InfuraResponseBody {
        return infuraApi.blockApi.getBlockInformationWithBlockNumber(blockNumber, false)
    }

    fun getLatestBlockHashAndBlockNumber(): BlockObject {
        val latestBlockNumber = getLatestBlockHash().result as BlockHash
        val latestBlockInformation = getBlockByBlockNumber(latestBlockNumber.toString()).result as BlockInformation

        return BlockObject(
            blockNumber = latestBlockNumber.toString(),
            blockHash = latestBlockInformation.hash
        )
    }

    fun verifyBlockHash(): Boolean {
        return false
    }
}