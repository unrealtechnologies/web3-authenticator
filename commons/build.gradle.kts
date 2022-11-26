group = "io.unreal.web3authenticator"

plugins {
    java
    kotlin("jvm") version "1.7.21"
    kotlin("plugin.serialization") version "1.7.20"
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14")
}
