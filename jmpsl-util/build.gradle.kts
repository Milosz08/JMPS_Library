/*
 * Copyright (c) 2022 by multiple authors
 *
 * File name: build.gradle.kts
 * Last modified: 13/10/2022, 15:53
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
    implementation("org.springframework.boot:spring-boot-starter:${rootProject.extra.get("springVersion") as String}")
    implementation("org.springframework.boot:spring-boot-starter-web:${rootProject.extra.get("springVersion") as String}")
    implementation("org.javatuples:javatuples:${rootProject.extra.get("jTuplesVersion") as String}")
}