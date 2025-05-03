plugins {
    kotlin("jvm") version "2.1.20"
    application
}

application {
    mainClass.set("McpKtorRouteProblemKt")
}

repositories {
    mavenCentral()
}

val ktorVersion = "3.1.2"
val kotlinMcpVersion = "0.5.0"

dependencies {
    implementation("io.ktor:ktor-server-netty-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-sse:$ktorVersion")
    implementation("io.modelcontextprotocol:kotlin-sdk:$kotlinMcpVersion")
    implementation("ch.qos.logback:logback-classic:1.5.18")
}

kotlin {
    jvmToolchain(17)
}
