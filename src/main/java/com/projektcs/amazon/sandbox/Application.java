package com.projektcs.amazon.sandbox;

import org.apache.camel.spring.boot.CamelSpringBootApplicationController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        LOGGER.info("Application start.");
        ApplicationContext context = SpringApplication.run(Application.class, args);
        context.getBean(CamelSpringBootApplicationController.class).run();
    }
}
