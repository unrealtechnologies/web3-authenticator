package io.unreal.web3authenticator.services

import io.unreal.web3authenticator.commons.objects.BlockHash
import io.unreal.web3authenticator.commons.objects.BlockInformation
import io.unreal.web3authenticator.commons.objects.InfuraResponseBody
import io.unreal.web3authenticator.httpclient.ethereum.infura.InfuraApi
import io.unreal.web3authenticator.objects.BlockObject
import org.springframework.stereotype.Service

@Service
class AuthenticatorService {
    val infuraApi = InfuraApi("")
    fun getBlockByHash(): InfuraResponseBody {
        return infuraApi.blockApi.getBlockByHash("0xb3b20624f8f0f86eb50dd04688409e5cea4bd02d700bf6e79e9384d47d6a5a35", false)
    }

    fun getLatestBlockHash(): InfuraResponseBody {
        return infuraApi.blockApi.getLatestBlock()
    }

    fun getBlockByBlockNumber(blockNumber: String): InfuraResponseBody {
        return infuraApi.blockApi.getBlockInformationWithBlockBumber(blockNumber, false)
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