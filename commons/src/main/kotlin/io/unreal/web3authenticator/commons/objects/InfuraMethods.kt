package io.unreal.web3authenticator.httpclient.ethereum.infura

import io.unreal.web3authenticator.commons.objects.BlockHash
import io.unreal.web3authenticator.commons.objects.BlockInformation
import kotlin.reflect.KClass

// Using a tripple here to represent function name, ID, and class
// But perhaps we should use a new data class to hold these values.
enum class InfuraMethods(val methodPair: Triple<String, String, KClass<*>>) {
    GETBLOCKHASH(Triple("eth_getBlockByHash", "1", BlockInformation::class)),
    GETLATESTBLOCKNUMBER(Triple("eth_blockNumber", "2", BlockHash::class));

    companion object {
        private val map = InfuraMethods.values().associateBy { it.methodPair.second }
        fun getWithId(id: Int): InfuraMethods {
            return getWithId(id.toString())
        }

        fun getWithId(id: String): InfuraMethods {
            if (map.contains(id)) {
                return map[id]!!
            }
            throw Error("ID not found in map")
        }
    }
}