plugins {
	java
	groovy
	jacoco
	id("org.springframework.boot") version "3.3.6"
	id("io.spring.dependency-management") version "1.1.6"
	id("com.google.cloud.tools.jib") version "3.4.4"
	id("org.shipkit.shipkit-changelog") version "2.0.1"
	id("org.shipkit.shipkit-github-release") version "2.0.1"
	id("org.shipkit.shipkit-auto-version") version "2.1.0"
}

group = "com.example"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

extra["spockBomVersion"] = "2.4-M4-groovy-4.0"
extra["mapstructVersion"] = "1.6.2"
extra["lombokMapstructVersion"] = "0.2.0"

dependencyManagement {
	imports {
		mavenBom(("org.spockframework:spock-bom:${property("spockBomVersion")}"))
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework:spring-webflux")

	compileOnly("org.projectlombok:lombok")

	annotationProcessor("org.projectlombok:lombok")
	annotationProcessor("org.mapstruct:mapstruct-processor:${property("mapstructVersion")}")
	annotationProcessor("org.projectlombok:lombok-mapstruct-binding:${property("lombokMapstructVersion")}")

	testAnnotationProcessor("org.mapstruct:mapstruct-processor:${property("mapstructVersion")}")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.boot:spring-boot-starter-webflux")
	testImplementation("org.testcontainers:spock")
	testImplementation("org.spockframework:spock-core")
	testImplementation("org.spockframework:spock-spring")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
