package io.unreal.web3authenticator.httpclient.ethereum.infura

class BlockApi(infuraClientApiKey: String): InfuraHttpClient(infuraClientApiKey = infuraClientApiKey) {
    fun getBlockByHash(blockHash: String, showTransactionDetails: Boolean) {
        val body = requestBuilder.build(
            method = InfuraMethods.GETBLOCKHASH,
            params = listOf(blockHash, showTransactionDetails)
        )

        val req = requestBuilder(
            url = getUrl(),
            body = body
        )

        retrieveResponse(req)
    }
}