package org.example.driven.service;

import lombok.extern.java.Log;
import org.example.port.model.Item;
import org.springframework.stereotype.Repository;

@Log
@Repository
public class AuctionDynamoDbRepository {
    public void storeItem(Item item) {

        log.info(item.toString());
        log.info("Item stored in DynamoDB");


    }
}
