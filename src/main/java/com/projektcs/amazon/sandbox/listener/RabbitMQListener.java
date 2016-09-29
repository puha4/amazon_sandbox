package com.projektcs.amazon.sandbox.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

public class RabbitMQListener implements MessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQListener.class);

    @Override
    public void onMessage(Message message) {
        LOGGER.info("message - " + new String(message.getBody()));
    }
}
