package io.unreal.web3authenticator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Web3AuthenticatorApplication

fun main(args: Array<String>) {
	runApplication<Web3AuthenticatorApplication>(*args)
}
