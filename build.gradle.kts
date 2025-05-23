plugins {
    id("java")
    id("application")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {

    // JAX-RS via Jersey 3.x
    implementation ("org.glassfish.jersey.core:jersey-server:3.1.1")
    implementation ("org.glassfish.jersey.containers:jersey-container-grizzly2-http:3.1.1")
    implementation ("org.glassfish.jersey.media:jersey-media-json-binding:3.1.1")
    implementation("org.glassfish.jersey.inject:jersey-hk2:3.1.1")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("org.example.productservice.Main")
}