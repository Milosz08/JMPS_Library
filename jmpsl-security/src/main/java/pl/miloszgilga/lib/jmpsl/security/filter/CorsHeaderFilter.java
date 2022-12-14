/*
 * Copyright (c) 2022 by multiple authors
 *
 * File name: CorsHeaderFilter.java
 * Last modified: 15/10/2022, 21:27
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

package pl.miloszgilga.lib.jmpsl.security.filter;

import org.slf4j.*;

import org.springframework.http.HttpMethod;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.*;

import java.util.Arrays;
import java.io.IOException;
import java.util.stream.Collectors;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;
import static pl.miloszgilga.lib.jmpsl.security.SecurityEnv.__SEC_CORS_CLIENT;

/**
 * Custom servlet {@link Filter} added extra cors headers (available rest methods, allowed authorization header keys and
 * cors client URI). This filter is auto-inserting by Spring Context. Before use this class, insert property:
 * <code>jmpsl.security.cors.client</code> in <code>application.properties</code> file with cors client URL address.
 *
 * @author Miłosz Gilga
 * @since 1.0.2
 */
@Component
@Order(HIGHEST_PRECEDENCE)
public class CorsHeaderFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(CorsHeaderFilter.class);

    private final String corsClient;
    private String flattedMethods;

    private static final HttpMethod[] REST_METHODS = { GET, POST, PUT, OPTIONS, PATCH, DELETE };
    private static final String[] ALLOW_HEADERS = {
            "x-requested-with", "authorization", "Content-Type", "Authorization", "credential", "X-XSRF-TOKEN",
    };

    public CorsHeaderFilter(Environment env) {
        corsClient = __SEC_CORS_CLIENT.getProperty(env);
        LOGGER.info("Successful loaded CORS HEADERS FILTER into Spring Context");
    }

    @Override
    public void init(FilterConfig filterConfig) {
        flattedMethods = Arrays.stream(REST_METHODS).map(Enum::name).collect(Collectors.joining(","));
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        final HttpServletResponse response = (HttpServletResponse) res;
        final HttpServletRequest request = (HttpServletRequest) req;

        response.setHeader("Access-Control-Allow-Origin", corsClient);
        response.setHeader("Access-Control-Allow-Methods", flattedMethods);
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", String.join(",", ALLOW_HEADERS));

        if (OPTIONS.name().equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {
    }
}
