package io.unreal.web3authenticator.serializers

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JavaType
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.node.ObjectNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.unreal.web3authenticator.commons.objects.InfuraMethods
import io.unreal.web3authenticator.commons.objects.InfuraResponseBody
import kotlin.reflect.KParameter
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.javaType

class InfuraResponseDeserializer : StdDeserializer<InfuraResponseBody>(InfuraResponseBody::class.java) {

    @OptIn(ExperimentalStdlibApi::class)
    fun getJavaType(ctxt: DeserializationContext, param: KParameter, id: String, jsonKey: String): JavaType {
        return when (jsonKey) {
            "result" -> {
                val clazz = InfuraMethods.getWithId(id).methodPair.third
                val constructor = clazz.primaryConstructor!!
                ctxt.typeFactory.constructType(constructor.returnType.javaType)
            }
            else -> {
                ctxt.typeFactory.constructType(param.type.javaType)
            }
        }
    }

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

        for (param: KParameter in constructor.parameters) {
            val property = properties.stream()
                .filter { item -> item.internalName.equals(param.name) }.findFirst()

            require(property.isPresent)
            val jsonName = property.get().fullName.toString()

            if (!tree.has(jsonName)) {
                if (param.isOptional) {
                    continue
                }
                throw RuntimeException("Missing required field: ${param.name}")
            }

            val node = tree.get(jsonName)

            if (node == null && !param.type.isMarkedNullable) {
                throw RuntimeException("Got null value for non-nullable field: ${param.name}")
            }

            val javatype = getJavaType(ctxt, param, tree.get("id").textValue(), jsonName)
            val reader = jacksonObjectMapper().readerFor(javatype)
            val obj = reader.readValue<Any?>(node)

            args[param] = obj
        }

        return constructor.callBy(args)
    }
}
