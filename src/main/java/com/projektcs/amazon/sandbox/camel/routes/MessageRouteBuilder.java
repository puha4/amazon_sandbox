package com.projektcs.amazon.sandbox.camel.routes;

import com.projektcs.amazon.sandbox.test.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageRouteBuilder extends AbstractMessageRouteBuilder {
    private TestBean testBean;
    private String queue;
    private String exchange;

    @Override
    public void configure() throws Exception {
        from(getRabbitURI(queue, exchange))
                .process(testBean)
                .to("stream:out");
    }

    @Autowired
    public void setTestBean(TestBean testBean) {
        this.testBean = testBean;
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
