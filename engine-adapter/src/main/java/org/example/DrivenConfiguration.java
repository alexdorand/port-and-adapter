package org.example;

import org.example.port.model.Item;
import org.example.port.model.ItemAuctionState;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.UUID;

@Configuration
@EntityScan("org.example.driven")
public class DrivenConfiguration {

    // this is hacked item to mock database and cache
    @Bean
    public Item cachedItem() {
        Item item = new Item();
        item.setAuctioneerID(UUID.randomUUID().toString());
        item.setItemAuctionState(ItemAuctionState.ACCEPTING_BID);
        item.setBids(new ArrayList<>());
        item.setStartTimestamp(System.currentTimeMillis());
        item.setSupplierId(UUID.randomUUID().toString());
        item.setReservedPrice(100f);
        item.setMinimumBidIncrease(10f);
        return item;
    }

}
