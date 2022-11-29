package io.unreal.web3authenticator.commons.objects

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

data class BlockHash(private val value: String): InfuraResult() {
    companion object {
        @JvmStatic
        @JsonCreator
        fun create(value: String) = BlockHash(value.toLowerCase())
    }

    @JsonValue
    override fun toString() = value
}