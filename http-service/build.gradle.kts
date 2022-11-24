import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
	id("org.springframework.boot") version "3.0.0-SNAPSHOT"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.7.21"
	kotlin("plugin.spring") version "1.7.21"
}

apply(plugin = "application")
apply(plugin = "io.spring.dependency-management")

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.web3j:core:5.0.0")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation(project(":http-client")) //project specific libraries
    implementation(project(":commons")) //project specific libraries

}

tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
    mainClass.set("io.unreal.web3authenticator.Web3AuthenticatorApplication")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict", "-Xemit-jvm-type-annotations")
        jvmTarget = "17"
    }
}
