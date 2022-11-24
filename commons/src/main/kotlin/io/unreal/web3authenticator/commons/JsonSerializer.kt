package io.unreal.web3authenticator.commons

import io.unreal.web3authenticator.commons.objects.Person
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.reflect.KClass

open class JsonSerializer {
    fun serialize(obj: CommonsObject) {
//        println(Json{ encodeDefaults = true }.encodeToString(obj))
    }

    fun serialize2(obj: Person) {
//        println(Json{ encodeDefaults = true }.encodeToString(obj))
    }
}
