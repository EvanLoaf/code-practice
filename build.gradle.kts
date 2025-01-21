plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

val ENABLE_PREVIEW = "--enable-preview"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21)) // Use Java 21
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.compilerArgs.add(ENABLE_PREVIEW) // Enable preview features for compilation
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    jvmArgs(ENABLE_PREVIEW) // Enable preview features for test runtime
}

tasks.withType<JavaExec>().configureEach {
    jvmArgs(ENABLE_PREVIEW) // Enable preview features for application runtime
}