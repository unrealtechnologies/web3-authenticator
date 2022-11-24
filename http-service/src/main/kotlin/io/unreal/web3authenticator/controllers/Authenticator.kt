package io.unreal.web3authenticator.controllers

import io.unreal.web3authenticator.commons.CommonsObject
import io.unreal.web3authenticator.commons.JsonSerializer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

import io.unreal.web3authenticator.httpclient.Test
import io.unreal.web3authenticator.commons.objects.InfuraRequestBody
import io.unreal.web3authenticator.commons.objects.Person


@RestController
class Authenticator {

    @GetMapping("/authenticate")
    fun authenticate(): String {

        val jsonSerializer = JsonSerializer()

        val person = Person(
            firstName = "Ariel",
            lastName = "Saldana"
        )

        person.serialize<Person>()
        return person.serialize<Person>()
    }
}