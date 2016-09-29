package com.projektcs.amazon.sandbox.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@PropertySource("classpath:application.properties")
@EnableMongoRepositories(basePackages = "com.projektcs.amazon.sandbox.repository")
public class DatabaseConfig extends AbstractMongoConfiguration {
    private String mongoHost;
    private int mongoPort;
    private String mongoDB;

    @Override
    protected String getDatabaseName() {
        return mongoDB;
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient(mongoHost, mongoPort);
    }

    @Value("${mongo.host}")
    public void setMongoHost(String mongoHost) {
        this.mongoHost = mongoHost;
    }

    @Value("${mongo.port}")
    public void setMongoPort(int mongoPort) {
        this.mongoPort = mongoPort;
    }

    @Value("${mongo.db}")
    public void setMongoDB(String mongoDB) {
        this.mongoDB = mongoDB;
    }
}
