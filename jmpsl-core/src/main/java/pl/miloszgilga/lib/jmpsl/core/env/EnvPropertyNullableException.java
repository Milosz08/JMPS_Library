/*
 * Copyright (c) 2022 by multiple authors
 *
 * File name: EnvPropertyNullableException.java
 * Last modified: 18.11.2022, 00:40
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

package pl.miloszgilga.lib.jmpsl.core.env;

/**
 * Exception throws when not found required environment variable property in <code>application.properties</code> file.
 *
 * @author Miłosz Gilga
 * @since 1.0.2
 * @see EnvPropertyHandler
 */
class EnvPropertyNullableException extends RuntimeException {
    EnvPropertyNullableException(String propertyName) {
        super(String.format("Property '%s' in application.properties file must be set before run app.", propertyName));
    }
}
