package org.example.driver;

import lombok.AllArgsConstructor;
import org.example.common.Adaptor;
import org.example.port.driver.BidPlacementPort;
import org.example.port.model.Bid;
import org.example.port.model.BidPlacementStatus;
import org.example.usecase.PlaceBidUsecase;

@Adaptor
@AllArgsConstructor
public class BidPlacementSqsAdapter implements BidPlacementPort {

    private PlaceBidUsecase placeBidUsecase;

    public void receiveBids() {
        // go through SQS messages and call placeBid here
    }

    @Override
    public BidPlacementStatus placeBid(Bid bid, String itemId) {
        return placeBidUsecase.placeBid(bid, itemId);
    }
}
