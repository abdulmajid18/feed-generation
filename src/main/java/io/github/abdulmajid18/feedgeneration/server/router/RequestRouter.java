package io.github.abdulmajid18.feedgeneration.server.router;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import io.github.abdulmajid18.feedgeneration.server.handler.HomeHandler;
import io.github.abdulmajid18.feedgeneration.server.handler.PostHandler;
import io.github.abdulmajid18.feedgeneration.server.statuscodes.HttpStatus;

import java.io.IOException;
import java.io.OutputStream;

public class RequestRouter {
    public void initializeRoutes(HttpServer server) {
        server.createContext("/", new UnknownRouteHandler());
        server.createContext("/home", new HomeHandler());
        server.createContext("/post", new PostHandler());
    }

    static class UnknownRouteHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException, IOException {
            String response = HttpStatus.NOT_FOUND.getMessage();
            exchange.sendResponseHeaders(HttpStatus.NOT_FOUND.getCode(), response.length());

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        }
    }
}
