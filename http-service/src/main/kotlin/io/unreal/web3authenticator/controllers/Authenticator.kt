package io.unreal.web3authenticator.controllers

import io.unreal.web3authenticator.commons.CommonsObject
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

        val jsonString = person.serializeToJsonString<Person>()

        val p: Person = CommonsObject.deserializeFromJsonString(jsonString)
        println(p)
        return person.serializeToJsonString<Person>()
    }
}