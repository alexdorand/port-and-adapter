package org.example.driven;

import lombok.AllArgsConstructor;
import org.example.common.Adaptor;
import org.example.driven.service.AuctionCacheRepository;
import org.example.driven.service.AuctionDynamoDbRepository;
import org.example.driven.service.AuctionTimestreamRepository;
import org.example.port.driven.AuctionPort;
import org.example.port.model.Item;
import org.example.port.model.ItemAuctionState;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.UUID;

@Adaptor
@AllArgsConstructor
public class AuctionAdapter implements AuctionPort {

    private AuctionDynamoDbRepository auctionDynamoDbRepository;
    private AuctionTimestreamRepository auctionTimestreamRepository;
    private AuctionCacheRepository auctionCacheRepository;

    @Override
    public void updateItem(Item item) {
        auctionDynamoDbRepository.storeItem(item);
        auctionTimestreamRepository.recordImmutableItem(item);
    }

    @Override
    public Item getItem(String itemId) {
        return auctionCacheRepository.getItem(itemId);
    }
}
