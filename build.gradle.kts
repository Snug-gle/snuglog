plugins {
	java
	id("org.springframework.boot") version "3.4.4"
	id("io.spring.dependency-management") version "1.1.7"
	id("com.diffplug.spotless") version "6.25.0"
}

group = "in.snugLog"
version = "0.0.1-SNAPSHOT"

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

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

spotless {
	java {
		googleJavaFormat("1.17.0")
		target("src/**/*.java")
	}
}


tasks.withType<Test> {
	useJUnitPlatform()

	// Mockito is currently self-attaching to enable the inline-mock-maker. This will no longer work in future releases of the JDK
	// byte-buddy-agent의 캐시 위치를 설정
	val byteBuddyAgentJar = file(
		"${System.getProperty("user.home")}/.gradle/caches/modules-2/files-2.1/net.bytebuddy/byte-buddy-agent/1.15.11/a38b16385e867f59a641330f0362ebe742788ed8/byte-buddy-agent-1.15.11.jar"
	)

	jvmArgs("-javaagent:$byteBuddyAgentJar")
}
