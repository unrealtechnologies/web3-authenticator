package io.unreal.web3authenticator.commons

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

open class CommonsObject {

    companion object {
        val mapper: ObjectMapper = jacksonObjectMapper().registerModule(
            KotlinModule.Builder()
                .withReflectionCacheSize(512)
                .configure(KotlinFeature.NullToEmptyCollection, false)
                .configure(KotlinFeature.NullToEmptyMap, false)
                .configure(KotlinFeature.NullIsSameAsDefault, false)
                .configure(KotlinFeature.SingletonSupport, false)
                .configure(KotlinFeature.StrictNullChecks, false)
                .build()
        )

        inline fun <reified T> jacksonDeserializeFromJsonString(jsonString: String): T {
            return mapper.readValue<T>(jsonString)
        }
    }

    fun jacksonSerializeToJsonString(): String {
        return mapper.writeValueAsString(this)
    }
}
