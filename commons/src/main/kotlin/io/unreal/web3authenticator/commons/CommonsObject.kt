package io.unreal.web3authenticator.commons

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.*
import io.unreal.web3authenticator.commons.objects.BlockInformation

open class CommonsObject {

    companion object {
//        val mapper = jacksonObjectMapper()
        val ptv = BasicPolymorphicTypeValidator.builder().build()
        val mapper = jacksonObjectMapper().registerModule(KotlinModule.Builder()
            .withReflectionCacheSize(512)
            .configure(KotlinFeature.NullToEmptyCollection, false)
            .configure(KotlinFeature.NullToEmptyMap, false)
            .configure(KotlinFeature.NullIsSameAsDefault, false)
            .configure(KotlinFeature.SingletonSupport, false)
            .configure(KotlinFeature.StrictNullChecks, false)
            .build())

//        val json = Json {
//            encodeDefaults = true
//            ignoreUnknownKeys = true
//        }
//        inline fun <reified T> deserializeFromJsonString(jsonString: String): T {
//            return json.decodeFromString<T>(jsonString)
//        }

//        fun jacksonDeserializeFromJsonString(jsonString: String): Any {
//            return mapper.readValue(jsonString)
//        }
        inline fun <reified T> jacksonDeserializeFromJsonString(jsonString: String): T {
//            mapper.registerSubtypes(BlockInformation::class.java)
//            mapper.activateDefaultTyping(this.ptv, ObjectMapper.DefaultTyping.NON_FINAL)
            val ret: T = mapper.readValue<T>(jsonString)
            return ret
        }
    }

//    inline fun <reified T> serializeToJsonString(): String {
//        return json.encodeToString(this as T)
//    }

    fun jacksonSerializeToJsonString(): String{
        return mapper.writeValueAsString(this)
    }
}
