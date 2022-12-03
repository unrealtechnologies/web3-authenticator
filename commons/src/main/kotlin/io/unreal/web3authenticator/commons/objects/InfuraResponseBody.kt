package io.unreal.web3authenticator.commons.objects

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import io.unreal.web3authenticator.commons.CommonsObject
import io.unreal.web3authenticator.serializers.InfuraResponseDeserializer

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = InfuraResponseDeserializer::class)
data class InfuraResponseBody(

    @JsonProperty("id")
    val id: String,

    @JsonProperty("jsonrpc")
    val jsonRPC: String,

    @JsonProperty("result")
    val result: InfuraResult
) : CommonsObject()
