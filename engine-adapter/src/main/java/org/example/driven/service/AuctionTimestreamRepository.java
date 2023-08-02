package org.example.driven.service;

import lombok.extern.java.Log;
import org.example.port.model.Item;
import org.springframework.stereotype.Repository;

@Log
@Repository
public class AuctionTimestreamRepository {
    public void recordImmutableItem(Item item) {
        log.info("Item stored in time series database AWS Timestream");
    }
}
