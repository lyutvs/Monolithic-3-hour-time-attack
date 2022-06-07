object Dependencies {

    // validation
    const val VALIDATION = "org.springframework.boot:spring-boot-starter-validation"

    // kotlin
    const val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect"
    const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
    const val JACKSON = "com.fasterxml.jackson.module:jackson-module-kotlin"

    // spring
    const val SPRING = "org.springframework.boot:spring-boot-starter"
    // test
    const val SPRING_TEST = "org.springframework.boot:spring-boot-starter-test:${PluginVersions.SPRING_BOOT_VERSION}"

    // database
    const val SPRING_DATA_JPA = "org.springframework.boot:spring-boot-starter-data-jpa"
    const val MYSQL_DRIVER = "mysql:mysql-connector-java"
    const val REDIS = "org.springframework.boot:spring-boot-starter-data-redis"

    // security
    const val SPRING_SECURITY = "org.springframework.boot:spring-boot-starter-security"
    const val JWT = "io.jsonwebtoken:jjwt:0.9.0"

    // web
    const val SPRING_WEB = "org.springframework.boot:spring-boot-starter-web"

    // properties
    const val PROPERTIES_SCAN = "org.springframework.boot:spring-boot-configuration-processor"

}
