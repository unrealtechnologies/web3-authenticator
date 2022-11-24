package io.unreal.web3authenticator.commons.objects

import io.unreal.web3authenticator.commons.CommonsObject
import kotlinx.serialization.Serializable

@Serializable
data class Person(val firstName: String, val lastName: String): CommonsObject() {}
