package org.example.driver.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class BidPlacementRequest {

    private String itemId;
    private String buyerId;
    private float amount;

}
