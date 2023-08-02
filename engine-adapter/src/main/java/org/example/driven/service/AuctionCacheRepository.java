package org.example.driven.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.example.port.model.Item;
import org.springframework.stereotype.Repository;


@Log
@Repository
@AllArgsConstructor
public class AuctionCacheRepository {

    // this is a hack to keep the item in memory for testing
    private Item item;

    public Item getItem(String itemId) {

        log.info("Retrieve item from cache");
        return item;
    }
}
