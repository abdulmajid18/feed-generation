package io.github.abdulmajid18.feedgeneration.server.handler.interceptor;


import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.util.logging.Logger;

public class RequestInterceptor {

    private static final Logger logger = Logger.getLogger(RequestInterceptor.class.getName());

    public void intercept(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();
        String requestURI = exchange.getRequestURI().toString();
        String headers = exchange.getRequestHeaders().toString();

        logger.info("Incoming request: Method=" + method + ", URI=" + requestURI + ", Headers=" + headers);
    }
}
