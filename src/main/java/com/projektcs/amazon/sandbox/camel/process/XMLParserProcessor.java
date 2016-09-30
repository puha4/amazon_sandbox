package com.projektcs.amazon.sandbox.camel.process;

import com.projektcs.amazon.sandbox.model.Item;
import com.projektcs.amazon.sandbox.repository.ItemRepository;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.polyglotted.xpathstax.XPathStaxParser;
import org.polyglotted.xpathstax.api.NodeHandler;
import org.polyglotted.xpathstax.model.XPathRequest;
import org.polyglotted.xpathstax.model.XmlNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Deque;
import java.util.LinkedList;

@Component
public class XMLParserProcessor implements Processor {
    private static final Logger LOGGER = LoggerFactory.getLogger(XMLParserProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        LOGGER.info("Xml parsing start.");

        InputStream inputStream = exchange.getIn().getBody(InputStream.class);

        final Deque<Item> result = new LinkedList<>();
        XPathStaxParser pathStaxParser = new XPathStaxParser();
        addItemSKUHandler(result, pathStaxParser);

        pathStaxParser.parse(inputStream);

        LOGGER.info("Element count - " + result.size());

        exchange.getIn().setBody(result);
    }

    private void addItemSKUHandler(final Deque<Item> result, XPathStaxParser pathStaxParser) {
        pathStaxParser.addHandler(new XPathRequest("/AmazonEnvelope/Message/Price/SKU"), new NodeHandler() {
            @Override
            //That method reacts when tag starts
            public void elementStart(String s) {
                result.addLast(new Item());
            }

            @Override
            //when it ends
            public void processNode(XmlNode xmlNode) {
                result.getLast().setCode(xmlNode.getText().asString());
                LOGGER.info(xmlNode.getText().asString());
            }
        });
    }
}
