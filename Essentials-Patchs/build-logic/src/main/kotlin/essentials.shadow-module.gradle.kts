import gradle.kotlin.dsl.accessors._d61068e8dd7a4c8c489a14bbbc096322.indra // Rebrand

plugins {
    id("essentials.module-conventions")
    id("io.github.goooler.shadow") // Rebrand
}

tasks {
    jar {
        archiveClassifier.set("unshaded")
    }
    shadowJar {
        archiveClassifier.set(null)
    }
}

extensions.configure<EssentialsModuleExtension> {
    archiveFile.set(tasks.shadowJar.flatMap { it.archiveFile })
}

// Rebrand
indra {
    javaVersions {
        target(21)
    }
}
// Rebrand