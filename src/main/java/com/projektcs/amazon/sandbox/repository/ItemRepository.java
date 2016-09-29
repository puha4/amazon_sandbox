package com.projektcs.amazon.sandbox.repository;

import com.projektcs.amazon.sandbox.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ItemRepository extends MongoRepository<Item, String> {

    List<Item> findByCode(String code);

    @Query("{'code' :  ?0}")
    List<Item> findByCodeCustom(String code);
}
