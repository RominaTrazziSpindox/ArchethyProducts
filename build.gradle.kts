plugins {
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.1.5"
    id("java")
}

group = "org.archethy"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
}

dependencies {

    // 🌐 Spring Boot Starter Web — per creare API REST, controller, ecc.
    implementation("org.springframework.boot:spring-boot-starter-web")

    // 🔐 Spring Security — per autenticazione e autorizzazione
    // implementation("org.springframework.boot:spring-boot-starter-security")

    // 💾 Spring Data JPA — per interagire con database (via Hibernate)
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // 🧠 Lombok — per generare automaticamente getter/setter, costruttori, ecc.
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    // 🧰 Database in memoria (H2) — utile per test o demo locali
    runtimeOnly("com.h2database:h2")

    // 🧩 JWT - autenticazione con JSON Web Token
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5") // usa Jackson per convertire oggetti in JSON

    // 🧪 Test — per scrivere test automatici
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

}

tasks.test {
    useJUnitPlatform()
}