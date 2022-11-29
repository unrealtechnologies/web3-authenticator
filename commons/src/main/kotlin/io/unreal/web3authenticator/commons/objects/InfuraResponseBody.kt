package io.unreal.web3authenticator.commons.objects

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import io.unreal.web3authenticator.commons.CommonsObject
import io.unreal.web3authenticator.serializers.InfuraResponseDeserializer

@JsonIgnoreProperties
//@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="id")
//@JsonSubTypes(
//    JsonSubTypes.Type(value = BlockInformation::class, name = "1"),
//    JsonSubTypes.Type(value = BlockHash::class, name = "2")
//)
@JsonDeserialize(using = InfuraResponseDeserializer::class)
data class InfuraResponseBody(

    @JsonProperty("id")
    val id: String,

    @JsonProperty("jsonrpc")
    val jsonRPC: String,

    @JsonProperty("result")
    val result: InfuraResult
//    val result: InfuraResult<BlockInformation>?
): CommonsObject() {
    constructor(): this("1", "nil", BlockHash("nil"))
}