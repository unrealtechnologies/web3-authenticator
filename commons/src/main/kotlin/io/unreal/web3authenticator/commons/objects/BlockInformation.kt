package io.unreal.web3authenticator.commons.objects

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import org.jetbrains.annotations.Nullable

@JsonIgnoreProperties(ignoreUnknown = true)
data class BlockInformation(
    @JsonProperty("difficulty")
    val difficulty: String,

    @Nullable
    @JsonProperty("extraData")
    val extraData: String?,

    @JsonProperty("gasLimit")
    val gasLimit: String,

    @JsonProperty("gasUsed")
    val gasUsed: String,

    @JsonProperty("hash")
    val hash: String,

    @JsonProperty("miner")
    val miner: String,

    @JsonProperty("mixHash")
    val mixHash: String,

    @JsonProperty("nonce")
    val nonce: String,

    @JsonProperty("number")
    val number: String,

    @JsonProperty("parentHash")
    val parentHash: String,

    @JsonProperty("receiptsRoot")
    val receiptsRoot: String,

    @JsonProperty("sha3Uncles")
    val sha3Uncles: String,

    @JsonProperty("size")
    val size: String,

    @JsonProperty("stateRoot")
    val stateRoot: String,

    @JsonProperty("timestamp")
    val timestamp: String,

    @JsonProperty("totalDifficulty")
    val totalDifficulty: String,

    @JsonProperty("transactions")
    val transactions: List<String>,

    @JsonProperty("transactionsRoot")
    val transactionsRoot: String,

    @JsonProperty("uncles")
    val uncles: List<String>
): InfuraResult()