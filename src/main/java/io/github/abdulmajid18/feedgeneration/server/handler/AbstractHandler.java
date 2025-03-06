package io.github.abdulmajid18.feedgeneration.server.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import io.github.abdulmajid18.feedgeneration.server.handler.interceptor.RequestInterceptor;
import io.github.abdulmajid18.feedgeneration.server.handler.interceptor.ResponseInterceptor;

import java.io.*;

public abstract class AbstractHandler implements HttpHandler {

    private final RequestInterceptor requestInterceptor = new RequestInterceptor();
    private final ResponseInterceptor responseInterceptor = new ResponseInterceptor();

    protected void sendResponse(HttpExchange exchange, String response, int code) throws IOException {
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(code, response.length());

        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }

    protected String readRequest(HttpExchange exchange) throws IOException {
        StringBuilder requestBody = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(exchange.getRequestBody())
        )){
            String line;
            while ((line = br.readLine()) != null){
                requestBody.append(line).append("\n");
            }
            return requestBody  .toString().trim();
        }

    }



    abstract Object readRequestBody(InputStream inputStream) throws IOException;

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        requestInterceptor.intercept(exchange);

        handleRequest(exchange);

        responseInterceptor.intercept(exchange);
    }

    protected abstract void handleRequest(HttpExchange exchange) throws IOException;
}
