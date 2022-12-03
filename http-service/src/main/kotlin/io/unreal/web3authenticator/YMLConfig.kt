package io.unreal.web3authenticator

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
data class YMLConfig(
    var environment: String = "",
    var httpClients: Map<String, HttpClientSettings> = emptyMap()
)

data class HttpClientSettings(
    var baseUrl: String = "",
    var apiKey: String = ""
)
