group = "io.unreal.web3authenticator"

plugins {
    java
    kotlin("jvm") version "1.7.21"
    kotlin("plugin.serialization") version "1.7.20"
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
}
