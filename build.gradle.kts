plugins {
    `java-library`
    `maven-publish`
    id("com.gradleup.shadow") version "9.0.0-beta13"
}


repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.codemc.io/repository/nms/")
    }
    maven {
        url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    }
    maven {
        url = uri("https://repo.extendedclip.com/releases/")
    }
    maven {
        url = uri("https://jitpack.io")
    }
    maven {
        url = uri("https://repo.aikar.co/content/groups/aikar/")
    }
    maven {
        url = uri("https://repo.glaremasters.me/repository/public/")
    }
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.18.2-R0.1-SNAPSHOT")
    compileOnly("org.spigotmc:spigot:1.18.2-R0.1-SNAPSHOT")
    compileOnly("net.luckperms:api:5.4")
    compileOnly("me.clip:placeholderapi:+")
    compileOnly("org.projectlombok:lombok:+")
    compileOnly("me.glaremasters:guilds:3.5.6.4-SNAPSHOT")
    compileOnly(files("lib/PermissionsEx.jar"))
    compileOnly(files("lib/zPermissions.jar"))
    compileOnly(files("lib/EssentialsGroupManager.jar"))
    compileOnly(files("lib/LibsDisguises-10.0.25.jar"))
    implementation("com.zaxxer:HikariCP:+")
    implementation("org.slf4j:slf4j-jdk14:+")
    implementation("com.google.guava:guava:31.0.1-jre")
    implementation("org.json:json:+")
    implementation("org.bstats.bStats-Metrics:bstats-bukkit:+")
    annotationProcessor("org.projectlombok:lombok:+")
}


group = "com.nametagedit"
version = "4.5.24"
description = "NametagEdit"
java.sourceCompatibility = JavaVersion.VERSION_1_8

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}

tasks.named<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar>("shadowJar") {
    archiveBaseName.set("NametagEdit")
    archiveClassifier.set("")
    archiveVersion.set("")

    minimize()

    dependencies {
        include(dependency("com.zaxxer:HikariCP"))
        include(dependency("org.slf4j:slf4j-jdk14"))
        include(dependency("org.bstats.bStats-Metrics:bstats-bukkit"))
    }

}
