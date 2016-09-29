package com.projektcs.amazon.sandbox.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.annotation.Resource;

@Configuration
@PropertySource("classpath:database.properties")
@EnableMongoRepositories(basePackages = "com.projektcs.amazon.sandbox.repository")
public class DatabaseConfig extends AbstractMongoConfiguration {

    @Resource
    private Environment env;

    @Override
    protected String getDatabaseName() {
        return env.getRequiredProperty("mongo.db");
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient(env.getRequiredProperty("mongo.host"), Integer.valueOf(env.getRequiredProperty("mongo.port")));
    }
}
