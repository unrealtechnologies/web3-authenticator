package io.unreal.web3authenticator.commons

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

open class CommonsObject {

    companion object {
        val mapper = jacksonObjectMapper()

//        val json = Json {
//            encodeDefaults = true
//            ignoreUnknownKeys = true
//        }
//        inline fun <reified T> deserializeFromJsonString(jsonString: String): T {
//            return json.decodeFromString<T>(jsonString)
//        }

        fun jacksonDeserializeFromJsonString() {

        }
    }

//    inline fun <reified T> serializeToJsonString(): String {
//        return json.encodeToString(this as T)
//    }

    fun jacksonSerializeToJsonString(): String{
        return mapper.writeValueAsString(this)
    }
}
