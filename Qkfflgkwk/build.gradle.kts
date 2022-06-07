import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version PluginVersions.JVM_VERSION
	id("org.springframework.boot") version PluginVersions.SPRING_BOOT_VERSION
	id("io.spring.dependency-management") version PluginVersions.DEPENDENCY_MANAGER_VERSION
	kotlin("plugin.spring") version PluginVersions.SPRING_PLUGIN_VERSION
	kotlin("plugin.jpa") version PluginVersions.JPA_PLUGIN_VERSION
	kotlin("kapt") version PluginVersions.KAPT_VERSION
}

group = "com.xquare"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation(Dependencies.SPRING)
	implementation(Dependencies.KOTLIN_REFLECT)
	implementation(Dependencies.KOTLIN_STDLIB)
	implementation(Dependencies.JACKSON)
	implementation(Dependencies.SPRING_TEST)
	implementation(Dependencies.SPRING_DATA_JPA)
	implementation(Dependencies.VALIDATION)
	implementation(Dependencies.REDIS)
	implementation(Dependencies.MYSQL_DRIVER)
	implementation(Dependencies.SPRING_WEB)
	implementation(Dependencies.SPRING_SECURITY)
	implementation(Dependencies.JWT)
	implementation(Dependencies.PROPERTIES_SCAN)
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

allOpen {
	annotation("javax.persistence.Entity")
	annotation("javax.persistence.MappedSuperclass")
	annotation("javax.persistence.Embeddable")
}

noArg {
	annotation("javax.persistence.Entity")
	annotation("javax.persistence.MappedSuperclass")
	annotation("javax.persistence.Embeddable")
}
