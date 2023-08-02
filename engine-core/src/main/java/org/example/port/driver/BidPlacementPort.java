package org.example.port.driver;

import org.example.port.model.Bid;
import org.example.port.model.BidPlacementStatus;

public interface BidPlacementPort {

    BidPlacementStatus placeBid(Bid bid, String itemId);

}
