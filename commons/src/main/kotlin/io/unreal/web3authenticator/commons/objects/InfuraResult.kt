package io.unreal.web3authenticator.commons.objects

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonSubTypes.Type
import com.fasterxml.jackson.annotation.JsonTypeInfo
import io.unreal.web3authenticator.httpclient.ethereum.infura.InfuraMethods

abstract class InfuraResult