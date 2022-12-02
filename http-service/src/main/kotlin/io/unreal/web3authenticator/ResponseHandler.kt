package io.unreal.web3authenticator

import io.unreal.web3authenticator.objects.FailedResponseObject
import io.unreal.web3authenticator.objects.MessageObject
import io.unreal.web3authenticator.objects.SuccessfulResponseObject
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

open class ResponseHandler {
    companion object {
        fun reply(payload: Any, status: HttpStatus): ResponseEntity<Any> {
            val successfulResponseObject = SuccessfulResponseObject(
                payload = payload
            )
            return ResponseEntity(successfulResponseObject, status)
        }

        fun error(errorMessage: String, status: HttpStatus): ResponseEntity<Any> {
            val failedResponseObject = FailedResponseObject(
                error = MessageObject(errorMessage)
            )
            return ResponseEntity(failedResponseObject, status)
        }
    }

}
