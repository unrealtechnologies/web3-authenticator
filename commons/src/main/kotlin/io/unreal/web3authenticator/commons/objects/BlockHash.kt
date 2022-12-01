package io.unreal.web3authenticator.commons.objects

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonValue

@JsonIgnoreProperties(ignoreUnknown=true)
data class BlockHash(private val value: String): InfuraResult() {
    companion object {
        @JvmStatic
        @JsonCreator
        fun create(value: String) = BlockHash(value.lowercase())
    }

    @JsonValue
    override fun toString() = value
}