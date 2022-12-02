package io.unreal.web3authenticator.controllers

import io.unreal.web3authenticator.ResponseHandler
import io.unreal.web3authenticator.commons.errors.HttpRequestFailedException
import io.unreal.web3authenticator.commons.objects.InfuraResponseBody
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import io.unreal.web3authenticator.services.AuthenticatorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping("/block")
class BlockController(@Autowired val authenticatorService: AuthenticatorService) {

    @GetMapping("/latest")
    fun getLatestBlockNumber(): ResponseEntity<Any> {
        return try {
            return ResponseHandler.reply(
                payload = authenticatorService.getLatestBlockHashAndBlockNumber(),
                status = HttpStatus.OK
            )
        } catch(e: HttpRequestFailedException) {
            e.printStackTrace()
            ResponseHandler.error(errorMessage = e.message!!, status = HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{blockNumber}")
    fun getBlockWithBlockNumber(@PathVariable blockNumber: String): InfuraResponseBody {
        return authenticatorService.getBlockByBlockNumber(blockNumber)
    }

}