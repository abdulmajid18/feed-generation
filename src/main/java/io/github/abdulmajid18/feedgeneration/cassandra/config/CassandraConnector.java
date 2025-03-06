package io.github.abdulmajid18.feedgeneration.cassandra.config;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CassandraConnector {

    private static final Logger logger = LoggerFactory.getLogger(CassandraConnector.class);

    private Cluster cluster;
    private Session session;

    public void connect(String node, Integer port) {
        logger.info("Attempting to connect to Cassandra at node: {} and port: {}", node, port);

        try {
            Cluster.Builder b = Cluster.builder().addContactPoint(node);
            if (port != null) {
                b.withPort(port);
            }
            cluster = b.build();
            session = cluster.connect();
            logger.info("Successfully connected to Cassandra at node: {} and port: {}", node, port);
        } catch (Exception e) {
            logger.error("Error connecting to Cassandra at node: {} and port: {}", node, port, e);
        }
    }

    public Session getSession() {
        return this.session;
    }

    public void close() {
        if (session != null) {
            logger.info("Closing Cassandra session.");
            session.close();
        }
        if (cluster != null) {
            logger.info("Closing Cassandra cluster connection.");
            cluster.close();
        }
    }
}
