package io.github.abdulmajid18.feedgeneration.cassandra.config;

import com.datastax.driver.core.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CassandraService {
    private static final Logger logger = LoggerFactory.getLogger(CassandraService.class);

    private static final CassandraService INSTANCE = new CassandraService();
    private CassandraConnector cassandraConnector;
    private Session session;

    private CassandraService() {
        logger.info("Initializing CassandraService...");
        cassandraConnector = new CassandraConnector();
        cassandraConnector.connect("localhost", 9042);
        session = cassandraConnector.getSession();
        logger.info("CassandraService initialized successfully.");
    }

    public static CassandraService getInstance() {
        return INSTANCE;
    }

    public void createKeyspace(String keyspaceName, String replicationStrategy, int replicationFactor) {
        logger.info("Attempting to create keyspace: {}", keyspaceName);
        StringBuilder sb =
                new StringBuilder("CREATE KEYSPACE IF NOT EXISTS ")
                        .append(keyspaceName).append(" WITH replication = {")
                        .append("'class':'").append(replicationStrategy)
                        .append("','replication_factor':").append(replicationFactor)
                        .append("};");

        String query = sb.toString();
        try {
            session.execute(query);
            logger.info("Keyspace '{}' created successfully with replication strategy '{}' and factor {}", keyspaceName, replicationStrategy, replicationFactor);
        } catch (Exception e) {
            logger.error("Error creating keyspace '{}' with replication strategy '{}' and factor {}: {}", keyspaceName, replicationStrategy, replicationFactor, e.getMessage());
        }
    }

    public void createPostTable(String keyspaceName) {
        logger.info("Attempting to create 'post' table in keyspace: {}", keyspaceName);
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ")
                .append(keyspaceName).append(".post(")
                .append("id uuid PRIMARY KEY, ")
                .append("content text, ")
                .append("created timestamp, ")
                .append("updated timestamp, ")
                .append("user_id uuid);");

        String query = sb.toString();
        try {
            session.execute(query);
            logger.info("'post' table created successfully in keyspace '{}'.", keyspaceName);
        } catch (Exception e) {
            logger.error("Error creating 'post' table in keyspace '{}': {}", keyspaceName, e.getMessage());
        }
    }
}
