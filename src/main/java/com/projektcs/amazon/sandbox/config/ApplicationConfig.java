package com.projektcs.amazon.sandbox.config;

import com.projektcs.amazon.sandbox.camel.process.XMLParserProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public XMLParserProcessor xmlParserProcessor() {
        return new XMLParserProcessor();
    }
}
