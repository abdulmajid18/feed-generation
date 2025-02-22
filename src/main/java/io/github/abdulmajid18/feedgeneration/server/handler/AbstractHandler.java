package io.github.abdulmajid18.feedgeneration.server.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public abstract class AbstractHandler implements HttpHandler {

    protected void sendResponse(HttpExchange httpExchange) {

    }
}
