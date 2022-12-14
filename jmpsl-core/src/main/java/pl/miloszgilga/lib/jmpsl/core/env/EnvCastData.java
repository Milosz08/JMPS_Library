/*
 * Copyright (c) 2022 by multiple authors
 *
 * File name: EnvCastData.java
 * Last modified: 18.11.2022, 02:21
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

import lombok.*;

/**
 * Simple POJO class storing available single casted property datatype.
 *
 * @param <T> type of casted primitive inbox object
 * @author Miłosz Gilga
 * @since 1.0.2
 */
@Data
@AllArgsConstructor
class EnvCastData<T> {
    private Class<T> castedClazz;
    private ICastCallbackResolver<T> callbackResolver;
}
