

plugins {
    id("java")
    id("application")
    id("org.openjfx.javafxplugin") version "0.1.0"
}


group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java{
    toolchain{
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

javafx{
    version= "25"
    modules= listOf("javafx.controls", "javafx.fxml")
}
application{
    mainClass.set("it.unicam.cs.mpgc.rpg129777.Main")
}

dependencies {
    implementation("com.google.code.gson:gson:2.11.0")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}