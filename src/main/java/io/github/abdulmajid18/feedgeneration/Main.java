package io.github.abdulmajid18.feedgeneration;

import io.github.abdulmajid18.feedgeneration.server.Server;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Server.class.getName());
    public static void main(String[] args) {
        try {
            new Server().start();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to start the server", e);
            throw new RuntimeException(e);
        }
    }
}