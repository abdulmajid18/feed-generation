package io.github.abdulmajid18.feedgeneration.server.handler.interceptor;


import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.util.logging.Logger;

public class ResponseInterceptor {

    private static final Logger logger = Logger.getLogger(ResponseInterceptor.class.getName());

    public void intercept(HttpExchange exchange) throws IOException {
        int statusCode = exchange.getResponseCode();
        logger.info("Response sent: Status Code=" + statusCode);
    }
}

