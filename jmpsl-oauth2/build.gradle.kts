/*
 * Copyright (c) 2022 by multiple authors
 *
 * File name: build.gradle.kts
 * Last modified: 18/10/2022, 21:57
 * Project name: jmps-library
 *
 * Licensed under the MIT license; you may not use this file except in compliance with the License.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * THE ABOVE COPYRIGHT NOTICE AND THIS PERMISSION NOTICE SHALL BE INCLUDED IN ALL
 * COPIES OR SUBSTANTIAL PORTIONS OF THE SOFTWARE.
 */

dependencies {
    implementation(project(":jmpsl-core"))
    implementation(project(":jmpsl-security"))

    implementation("org.projectlombok:lombok:${rootProject.extra.get("lombokVersion") as String}")
    annotationProcessor("org.projectlombok:lombok:${rootProject.extra.get("lombokVersion") as String}")

    implementation("javax.persistence:javax.persistence-api:${rootProject.extra.get("javaxPersistenceVersion") as String}")
    implementation("javax.validation:validation-api:${rootProject.extra.get("javaxValidationVersion") as String}")

    implementation("org.springframework.boot:spring-boot-starter:${rootProject.extra.get("springVersion") as String}")
    implementation("org.springframework.boot:spring-boot-starter-web:${rootProject.extra.get("springVersion") as String}")
    implementation("org.springframework.boot:spring-boot-starter-security:${rootProject.extra.get("springVersion") as String}")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-client:${rootProject.extra.get("springVersion") as String}")
}
