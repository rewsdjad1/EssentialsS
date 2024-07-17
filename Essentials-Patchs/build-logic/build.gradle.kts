plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("net.kyori", "indra-common", "3.1.3")
    implementation("io.github.goooler.shadow", "shadow-gradle-plugin", "8.1.8") // Rebrand
    implementation("xyz.jpenilla", "run-task", "2.3.0")
}
