package com.projektcs.amazon.sandbox.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.properties")
abstract class AbstractMessageRouteBuilder extends RouteBuilder {
    private String host;

    protected String getRabbitURI(String queue, String exchange) {
        if (StringUtils.isEmpty(queue)) {
            throw new IllegalArgumentException("Queue can not be empty.");
        }

        if (StringUtils.isEmpty(exchange)) {
            throw new IllegalArgumentException("Exchange can not be empty");
        }

        if (StringUtils.isEmpty(host)) {
            throw new IllegalStateException("Host can not be empty");
        }

        return "rabbitmq://"+
                host + "/"+ exchange +
                "?queue="+ queue +"&autoDelete=false";
    }

    @Value("${rabbit.host}")
    public void setHost(String host) {
        this.host = host;
    }
}
