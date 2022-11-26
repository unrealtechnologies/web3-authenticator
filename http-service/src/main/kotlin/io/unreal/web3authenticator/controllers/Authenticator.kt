package io.unreal.web3authenticator.controllers

import io.unreal.web3authenticator.commons.CommonsObject
import io.unreal.web3authenticator.commons.objects.InfuraRequestBody
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

import io.unreal.web3authenticator.commons.objects.Person


@RestController
class Authenticator {

    @GetMapping("/authenticate")
    fun authenticate(): String {
        val person = Person(
            firstName = "Ariel",
            lastName = "Saldana"
        )


//        val credentials = buildJsonArray {
//                addJsonObject {
//                    put("publicKey", "publickey")
//                    put("privateKey", false)
//                }
//            }


        val infuraRequestBody: InfuraRequestBody = InfuraRequestBody(
            jsonRPC = "2.0",
            method = "eth_getBlockByHash",
            params = listOf("0xb3b20624f8f0f86eb50dd04688409e5cea4bd02d700bf6e79e9384d47d6a5a35", false)
//            params = listOf("0xb3b20624f8f0f86eb50dd04688409e5cea4bd02d700bf6e79e9384d47d6a5a35", false)
        )

//        println(infuraRequestBody.serializeToJsonString<InfuraRequestBody>())


        val jsonString = person.serializeToJsonString<Person>()

        val p: Person = CommonsObject.deserializeFromJsonString(jsonString)
        println(p)

        val ls = mutableListOf<Any>()
        ls.add("meow")
        ls.add(false)

        println(ls)


        return infuraRequestBody.jacksonSerializeToJsonString()
//        return person.serializeToJsonString<Person>()
    }
}