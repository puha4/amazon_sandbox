package com.projektcs.amazon.sandbox.camel.routes;

import com.projektcs.amazon.sandbox.camel.process.ItemSaveProcessor;
import com.projektcs.amazon.sandbox.camel.process.XMLParserProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageRouteBuilder extends AbstractMessageRouteBuilder {
    private XMLParserProcessor xmlParserProcessor;
    private ItemSaveProcessor itemSaveProcessor;
    private String queue;
    private String exchange;

    @Override
    public void configure() throws Exception {
        from(getRabbitURI(queue, exchange))
                .process(xmlParserProcessor)
                .process(itemSaveProcessor)
                .to("stream:out");
    }

    @Autowired
    public void setXMLParserProcessor(XMLParserProcessor xmlParserProcessor) {
        this.xmlParserProcessor = xmlParserProcessor;
    }

    @Autowired
    public void setItemSaveProcessor(ItemSaveProcessor itemSaveProcessor) {
        this.itemSaveProcessor = itemSaveProcessor;
    }

    @Value("${rabbit.queue}")
    public void setQueue(String queue) {
        this.queue = queue;
    }

    @Value("${rabbit.exchange}")
    public void setExchange(String exchange) {
        this.exchange = exchange;
    }
}
