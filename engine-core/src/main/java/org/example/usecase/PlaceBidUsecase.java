package org.example.usecase;

import lombok.AllArgsConstructor;
import org.example.common.UseCase;
import org.example.port.driven.AuctionPort;
import org.example.port.driven.EventPort;
import org.example.port.driven.FraudDetectionPort;
import org.example.port.model.*;

import static org.example.common.model.Events.*;
import static org.example.port.model.BidPlacementStatus.*;


@UseCase
@AllArgsConstructor
public class PlaceBidUsecase {

    private EventPort eventPort;
    private AuctionPort auctionPort;
    private FraudDetectionPort fraudDetectionPort;


    public BidPlacementStatus placeBid(Bid bid, String itemId) {

        if(isFraudDetectedFor(bid)) {

            eventPort.trigger(FRAUD_DETECTED(itemId));
            return REJECTED;

        } else {

            Item item = auctionPort.getItem(itemId);
            BidPlacementStatus bidStatus = item.record(bid);
            auctionPort.updateItem(item);

            if(bidStatus == ACCEPTED) {
                eventPort.trigger(BID_ACCEPTED(itemId));
            }

            return bidStatus;
        }
    }

    private boolean isFraudDetectedFor(Bid bid) {
        FraudDetectionResult fraudDetectionResult = fraudDetectionPort.detectFraud(bid);
        return fraudDetectionResult.fraudLikelihood().equals(FraudProbability.UNLIKELY) ||
                fraudDetectionResult.fraudLikelihood().equals(FraudProbability.HIGHLY_UNLIKELY);
    }

}
