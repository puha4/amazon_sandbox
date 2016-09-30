package com.projektcs.amazon.sandbox.camel.process;

import com.projektcs.amazon.sandbox.model.Item;
import com.projektcs.amazon.sandbox.repository.ItemRepository;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Deque;

@Component
public class ItemSaveProcessor implements Processor {
    private static final Logger LOGGER = LoggerFactory.getLogger(XMLParserProcessor.class);

    private ItemRepository repository;

    @Override
    @SuppressWarnings("unchecked")
    public void process(Exchange exchange) throws Exception {
        final Deque<Item> items = exchange.getIn().getBody(Deque.class);
        LOGGER.info("Count - " + items.size());

        repository.insert(items);

        exchange.getIn().setBody(items.getFirst().getCode());
    }

    @Autowired
    public void setRepository(ItemRepository repository) {
        this.repository = repository;
    }
}
