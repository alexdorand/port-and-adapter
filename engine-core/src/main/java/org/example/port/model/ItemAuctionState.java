package org.example.port.model;

import lombok.Getter;

@Getter
public enum ItemAuctionState {

    INACTIVE,
    ACCEPTING_BID,
    CONCLUDED,
    CANCELLED,
    RESERVE_NOT_MET

}
