import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
    kotlin("plugin.serialization") version "1.7.20"
}

allprojects {
    group = "io.unreal.web3authenticator"
    version = "0.0.1-SNAPSHOT"

    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
        maven { url = uri("https://repo.spring.io/milestone") }
        maven { url = uri("https://repo.spring.io/snapshot") }
        maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
    }

    dependencies {
        implementation("com.pinterest:ktlint:0.47.1")
        // implementation("com.pinterest:ktlint:<latest-version>-kotlin-dev-SNAPSHOT")
    }

}

subprojects {
    apply(from = "$rootDir/ktlint.gradle")

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }
}

java.sourceCompatibility = JavaVersion.VERSION_17

//tasks.withType<Test> {
//    useJUnitPlatform()
//}
