package io.unreal.web3authenticator.commons.objects

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonSubTypes.Type
import com.fasterxml.jackson.annotation.JsonTypeInfo
import io.unreal.web3authenticator.httpclient.ethereum.infura.InfuraMethods

//@JsonTypeInfo(use= JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
//@JsonSubTypes(
//    JsonSubTypes.Type(value = BlockInformation::class, name = "BlockInformation"),
//    JsonSubTypes.Type(value = BlockHash::class, name = "BlockHash")
//)

//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "shapeName")
//@JsonSubTypes({
//    @JsonSubTypes.Type(value = Square.class, name = "square"),
//    @JsonSubTypes.Type(value = Circle.class, name = "circle")
//})

//@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="difficulty")
//@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="difficulty")
//@JsonSubTypes(
//    JsonSubTypes.Type(value = BlockInformation::class, name = "0xbfabcdbd93dda"),
//    JsonSubTypes.Type(value = BlockHash::class, name = 2.toString())
//)

//@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="difficulty")
//@JsonSubTypes(
//    JsonSubTypes.Type(value = BlockInformation::class, name = "0xbfabcdbd93dda")
//    JsonSubTypes.Type(value = BlockHash::class, name = "2")
//)
abstract class InfuraResult