package com.projektcs.amazon.sandbox.config;

import com.projektcs.amazon.sandbox.test.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
public class ApplicationConfig {

    @Bean
    public Test test() {
        return new Test();
    }
}
