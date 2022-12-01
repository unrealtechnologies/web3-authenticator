package io.unreal.web3authenticator.commons.objects

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.unreal.web3authenticator.commons.CommonsObject

@JsonIgnoreProperties
data class InfuraRequestBody(

    @JsonProperty("id")
    val id: String,

    @JsonProperty("jsonrpc")
    val jsonRPC: String,

    @JsonProperty("method")
    val method: String,

    @JsonProperty("params")
    val params: List<Any>?

): CommonsObject()