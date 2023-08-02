package org.example.port.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Bid {

    private String id;
    private String buyerId;
    private float amount;
    private long placedOnTimestamp;
    private BidPlacementStatus bidPlacementStatus;
    private FraudDetectionResult fraudDetectionResult;

}
