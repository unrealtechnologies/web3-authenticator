package io.unreal.web3authenticator.commons

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
open class CommonsObject {

    inline fun <reified T> serialize(): String {
        return Json{ encodeDefaults = true }.encodeToString(this as T)
    }
}
