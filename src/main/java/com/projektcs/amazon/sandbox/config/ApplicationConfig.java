package com.projektcs.amazon.sandbox.config;

import com.projektcs.amazon.sandbox.test.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public TestBean testBean() {
        return new TestBean();
    }
}
