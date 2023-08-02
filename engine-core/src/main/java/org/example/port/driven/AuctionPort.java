package org.example.port.driven;

import org.example.port.model.BidPlacementStatus;
import org.example.port.model.Item;

public interface AuctionPort {

    public void updateItem(Item item);
    public Item getItem(String itemId);

}
