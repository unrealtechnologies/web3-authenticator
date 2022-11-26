package io.unreal.web3authenticator.httpclient.ethereum.infura

class BlockApi(infuraClientApiKey: String): InfuraHttpClient(infuraClientApiKey = infuraClientApiKey) {
    fun getBlockByHash(blockHash: String, showTransactionDetails: Boolean): String {
        val body = requestBuilder.build(
            method = InfuraMethods.GETBLOCKHASH,
            params = listOf(blockHash, showTransactionDetails)
        )

        val req = requestBuilder(
            url = getUrl(),
            body = body
        )

        val res = retrieveResponse(req)
        return res.body!!.string()
    }
}