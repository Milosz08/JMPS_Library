/*
 * Copyright (c) 2022 by multiple authors
 *
 * File name: ControllerSecurityPathExclude.java
 * Last modified: 21/10/2022, 21:24
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

package pl.miloszgilga.lib.jmpsl.security.excluder;

import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * Implement this annotation on Spring Controller class, if you can exclude all controller REST methods paths from
 * Spring Security Context. This annotation MUST BE TOGETHER with {@link RequestMapping} annotation and
 * {@link RequestMapping} value cannot be empty or null.
 *
 * @author Miłosz Gilga
 * @since 1.0.2
 */
@Target(TYPE)
@Retention(CLASS)
public @interface ControllerSecurityPathExclude {
}
