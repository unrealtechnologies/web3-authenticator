package io.unreal.web3authenticator.commons

import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

open class CommonsObject {

    companion object {
        val json = Json{ encodeDefaults = true }
        inline fun <reified T> deserializeFromJsonString(jsonString: String): T {
            return json.decodeFromString<T>(jsonString)
        }
    }

    inline fun <reified T> serializeToJsonString(): String {
        return json.encodeToString(this as T)
    }
}
