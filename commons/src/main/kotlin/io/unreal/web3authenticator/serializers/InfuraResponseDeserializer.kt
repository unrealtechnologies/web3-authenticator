package io.unreal.web3authenticator.serializers

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JavaType
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate.Param
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter
import com.fasterxml.jackson.databind.node.ObjectNode
import io.unreal.web3authenticator.commons.objects.InfuraResponseBody
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.unreal.web3authenticator.commons.objects.BlockHash
import io.unreal.web3authenticator.commons.objects.BlockInformation
import kotlin.jvm.internal.Intrinsics.Kotlin
import kotlin.reflect.*
import kotlin.reflect.full.companionObject
import kotlin.reflect.full.createType
import kotlin.reflect.full.primaryConstructor

class InfuraResponseDeserializer: StdDeserializer<InfuraResponseBody>(InfuraResponseBody::class.java) {

    @OptIn(ExperimentalStdlibApi::class)
    fun getJavaType(ctxt: DeserializationContext, param: KParameter, id: String, jsonKey: String): JavaType {
        when {
            jsonKey == "result" -> {
                val clazz = BlockInformation::class
                val constructor = clazz.primaryConstructor!!
                return ctxt.typeFactory.constructType(constructor.returnType.javaType)
            }
            else -> return ctxt.typeFactory.constructType(param.type.javaType)
        }
    }


    @OptIn(ExperimentalStdlibApi::class)
    override fun deserialize(jsonParser: JsonParser, ctxt: DeserializationContext): InfuraResponseBody {
        val clazz = InfuraResponseBody::class
        val constructor = clazz.primaryConstructor!!

        // we get the properties as jackson defines them so we can properly
        // obtain json values. AKA parameter might be ID in kotlin, but {"id"... in JSON.
        val javaType = ctxt.typeFactory.constructType(InfuraResponseBody::class.java)
        val beanDescription = jacksonObjectMapper().serializationConfig.introspect(javaType)
        val properties = beanDescription.findProperties()

        val tree = jsonParser.readValueAsTree<ObjectNode>()
        val args = mutableMapOf<KParameter, Any?>()

        for (param : KParameter in constructor.parameters) {
            val property = properties.stream()
                .filter { item -> item.internalName.equals(param.name) }.findFirst()
            require(property.isPresent)

            val jsonName = property.get().fullName.toString()
            val internalName = property.get().internalName.toString()

            if (!tree.has(jsonName)) {
                if (param.isOptional) {
                    println("Skipping for param.name: $internalName")
                    continue
                }
                throw RuntimeException("Missing required field: ${param.name}")
            }

            val node = tree.get(jsonName)

            if (node == null && !param.type.isMarkedNullable) {
                throw RuntimeException("Got null value for non-nullable field: ${param.name}")
            }

            var javatype = getJavaType(ctxt, param, tree.get("id").toString(), jsonName)
            val reader = jacksonObjectMapper().readerFor(javatype)
            val obj = reader.readValue<Any?>(node)
            println("$internalName ${param.type} $javaType")

            args[param] = obj
        }

        return constructor.callBy(args)
    }
}
