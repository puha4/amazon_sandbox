package com.projektcs.amazon.sandbox;

import com.projektcs.amazon.sandbox.config.ApplicationConfig;
import com.projektcs.amazon.sandbox.config.DatabaseConfig;
import com.projektcs.amazon.sandbox.config.RabbitConfig;
import com.projektcs.amazon.sandbox.model.Item;
import com.projektcs.amazon.sandbox.repository.ItemRepository;
import com.projektcs.amazon.sandbox.test.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class, DatabaseConfig.class, RabbitConfig.class);
        Test test = context.getBean(Test.class);
        ItemRepository itemRepository = context.getBean(ItemRepository.class);

        test.hello();

//        Item item = new Item("00001");

//        itemRepository.save(item);

//        List<Item> items = itemRepository.findByCodeCustom("00001");
//
//        for (Item item : items) {
//            LOGGER.info("Item - " + item);
//        }
    }
}
