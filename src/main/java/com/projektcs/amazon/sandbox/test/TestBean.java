package com.projektcs.amazon.sandbox.test;

import com.projektcs.amazon.sandbox.model.Item;
import com.projektcs.amazon.sandbox.repository.ItemRepository;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestBean implements Processor {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestBean.class);

    private ItemRepository repository;

    @Override
    public void process(Exchange exchange) throws Exception {
        LOGGER.info("Test Bean");
        Item item = Item.create(exchange.getIn().getBody(String.class));
        repository.save(item);
        exchange.getIn().setBody(item);
    }

    @Autowired
    public void setRepository(ItemRepository repository) {
        this.repository = repository;
    }
}
