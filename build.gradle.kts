plugins {
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.serialization") version "2.0.0"
    `maven-publish`
}

group = "net.cakeyfox"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("io.ktor:ktor-client-core:3.0.3")
    implementation("io.ktor:ktor-client-cio:3.0.3")
    implementation("io.ktor:ktor-client-content-negotiation:3.0.3")
    implementation("io.ktor:ktor-serialization-kotlinx-json:3.0.3")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            groupId = "com.github.FoxyTheBot"
            artifactId = "ValorantWrapper"
            version = project.version.toString()

            pom {
                name.set("Valorant Wrapper")
                description.set("A simple wrapper for HenrikDev's unofficial VALORANT API")
                url.set("https://github.com/FoxyTheBot/ValorantWrapper")

                licenses {
                    license {
                        name.set("AGPL-3.0 License")
                        url.set("https://opensource.org/licenses/AGPL-3.0")
                    }
                }

                developers {
                    developer {
                        id.set("WinG4merBR")
                        name.set("WinG4merBR")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/FoxyTheBot/ValorantWrapper.git")
                    developerConnection.set("scm:git:ssh://github.com/FoxyTheBot/ValorantWrapper.git")
                    url.set("https://github.com/FoxyTheBot/ValorantWrapper")
                }
            }
        }
    }

    repositories {
        maven {
            url = uri("https://jitpack.io")
            credentials {
                username = System.getenv("JITPACK_USERNAME") ?: project.findProperty("jitpack.username").toString()
                password = System.getenv("JITPACK_TOKEN") ?: project.findProperty("jitpack.token").toString()
            }
        }
    }
}
kotlin {
    jvmToolchain(21)
}