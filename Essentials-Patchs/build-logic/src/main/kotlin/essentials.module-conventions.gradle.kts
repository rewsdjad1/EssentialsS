import gradle.kotlin.dsl.accessors._d61068e8dd7a4c8c489a14bbbc096322.indra // Rebrand

plugins {
    id("essentials.base-conventions")
    id("xyz.jpenilla.run-paper")
}

val moduleExtension = extensions.create<EssentialsModuleExtension>("essentialsModule", project)

tasks {
    runServer {
        minecraftVersion(RUN_PAPER_MINECRAFT_VERSION)
        runDirectory(rootProject.file("run"))
        javaLauncher.set(javaToolchains.launcherFor(java.toolchain))
        if (project.name != "EssentialsX") {
            pluginJars.from(rootProject.project(":EssentialsX").the<EssentialsModuleExtension>().archiveFile)
        }
    }
    jar {
        moduleExtension.archiveFile.set(archiveFile)
    }
    val copyJar = register<FileCopyTask>("copyJar") {
        fileToCopy.set(moduleExtension.archiveFile)
        destination.set(rootProject.layout.projectDirectory.dir(provider { "jars" }).flatMap {
            it.file(fileToCopy.map { file -> file.asFile.name })
        })
    }
    build {
        dependsOn(copyJar)
    }
}

// Rebrand
indra {
    javaVersions {
        target(21)
    }
}
// Rebrand