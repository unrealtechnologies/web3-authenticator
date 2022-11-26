//package io.unreal.web3authenticator.serializers
//
//import io.unreal.web3authenticator.commons.objects.InfuraRequestBody
//import kotlinx.serialization.ExperimentalSerializationApi
//import kotlinx.serialization.KSerializer
//import kotlinx.serialization.Serializer
//import kotlinx.serialization.builtins.ListSerializer
//import kotlinx.serialization.builtins.serializer
//import kotlinx.serialization.descriptors.SerialDescriptor
//import kotlinx.serialization.descriptors.element
//import kotlinx.serialization.descriptors.buildClassSerialDescriptor
//import kotlinx.serialization.encoding.Decoder
//import kotlinx.serialization.encoding.Encoder
//import kotlinx.serialization.encoding.encodeStructure
//import kotlinx.serialization.json.*
//
////public fun String.Companion.serializer(): KSerializer<String> = StringSerializer
//
//
//@ExperimentalSerializationApi
//@Serializer(forClass = InfuraRequestBody::class)
//object InfuraRequestBodySerializer : KSerializer<InfuraRequestBody> {
//    override val descriptor: SerialDescriptor =
//        buildClassSerialDescriptor("InfuraRequestBody") {
//            element<String>("jsonRpc")
//            element<String>("method")
//            element<List<String>>("params")
//        }
//
//    override fun serialize(encoder: Encoder, value: InfuraRequestBody) {
//
////        encoder.encodeString(value.toString())
//        encoder.encodeStructure(descriptor) {
//            encodeStringElement(descriptor, 0, value.jsonRpc)
//            encodeStringElement(descriptor, 1, value.method)
//
////            List<{Comparable{Boolean & String}> & java.io.Serializable}>
//
//
//            val credentials = buildJsonArray {
//                addJsonObject {
//                    put("publicKey", "publickey")
//                    put("privateKey", false)
//                }
//            }
//
////            encodeSerializableElement(descriptor, 2, ListSerializer(serializer), listOf("meow", false))
////            encodeSerializableElement(descriptor, 2, ListSerializer(JsonArray.serializer()), credentials)
////            encodeSerializableElement(descriptor, 2, credentials)
//            encodeStringElement(descriptor, 2, credentials.toString())
////            encodeSerializableElement(descriptor, 2, ListSerializer(String.serializer()), value.params)
//        }
//    }
//
//    override fun deserialize(decoder: Decoder): InfuraRequestBody {
//        return InfuraRequestBody(jsonRpc = "", method = "", listOf(""))
////        return InfuraRequestBody.fromString(decoder.decodeString())
//    }
//}