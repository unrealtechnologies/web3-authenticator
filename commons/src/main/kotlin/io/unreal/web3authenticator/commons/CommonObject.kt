package io.unreal.web3authenticator.commons
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString

abstract class CommonObject: ObjectInterface() {

    fun encodeToJsonString(): String {
        return _encodeToJsonString(this)
    }

    companion object {
        private val json = Json { encodeDefaults = true }
        fun _encodeToJsonString(obj: ObjectInterface): String {
            println(obj)
            println(this.json.encodeToString(obj))
            return this.json.encodeToString(obj)
        }

        fun _decodeFromJsonString(jsonString: String): ObjectInterface {
            return Json.decodeFromString<ObjectInterface>(jsonString)
        }
    }
}