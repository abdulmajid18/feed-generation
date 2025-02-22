package io.github.abdulmajid18.feedgeneration.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HttpServerApp {
    private static final Logger LOGGER = Logger.getLogger(HttpServerApp.class.getName());
    private HttpServer server;

    private static final int PORT = 8080;

    public void start() throws IOException {
        server = HttpServer.create(new InetSocketAddress(PORT), 0);

        LOGGER.info("Initializing request router...");

        RequestRouter router = new RequestRouter();
        router.initializeRoutes(server);

        server.setExecutor(Executors.newFixedThreadPool(10));

        LOGGER.info("Starting HTTP server on port " + PORT);
        server.start();
    }

    public static void main(String[] args) {
        try {
            new HttpServerApp().start();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to start the server", e);
            throw new RuntimeException(e);
        }
    }
}
