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
    fun getBlockByHash(hash: String): InfuraResponseBody {
        return infuraApi.blockApi.getBlockByHash(hash, false)
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