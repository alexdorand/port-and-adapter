package org.example.driver.converter;

import org.example.driver.dto.BidPlacementRequest;
import org.example.port.model.Bid;
import org.example.port.model.BidPlacementStatus;

import java.util.UUID;

public class BidPlacementConverter {

    public static Bid convertToBid(BidPlacementRequest request) {
        return Bid.builder()
                .id(UUID.randomUUID().toString())
                .amount(request.getAmount())
                .buyerId(request.getBuyerId())
                .placedOnTimestamp(System.currentTimeMillis())
                .bidPlacementStatus(BidPlacementStatus.PENDING)
                .build();
    }

}
