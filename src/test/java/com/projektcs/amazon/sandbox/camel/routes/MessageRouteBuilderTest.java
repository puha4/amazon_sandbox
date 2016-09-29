package com.projektcs.amazon.sandbox.camel.routes;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MessageRouteBuilderTest {

    private MessageRouteBuilder messageRouteBuilder;

    @Before
    public void initialize() {
        messageRouteBuilder = new MessageRouteBuilder();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetRabbitURINullParamsThrowError() throws Exception {
        messageRouteBuilder.setHost("host");
        messageRouteBuilder.getRabbitURI(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetRabbitURINullQueueThrowError() {
        messageRouteBuilder.setHost("host");
        messageRouteBuilder.getRabbitURI(null, "exchange");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetRabbitURINullExchangeThrowError() {
        messageRouteBuilder.setHost("host");
        messageRouteBuilder.getRabbitURI("queue", null);
    }

    @Test(expected = IllegalStateException.class)
    public void testGetRabbitURINullHostThrowError() {
        messageRouteBuilder.setHost(null);
        messageRouteBuilder.getRabbitURI("queue", "exchange");
    }

    @Test
    public void testGetRabbitURLCorrectParams() {
        messageRouteBuilder.setHost("localhost");
        String rabbitURI = messageRouteBuilder.getRabbitURI("queue", "exchange");

        assertThat(rabbitURI, is(equalTo("rabbitmq://localhost/exchange?queue=queue&autoDelete=false")));
    }

}