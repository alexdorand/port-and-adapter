package org.example.port.model;

import lombok.Data;
import org.example.common.AggregateRoot;

import java.util.List;

import static org.example.port.model.ItemAuctionState.*;

@Data
@AggregateRoot
public class Item {

    private String id;
    private String auctioneerID;
    private String supplierId;
    private List<Bid> bids;
    private Bid winningBid;
    private float reservedPrice;
    private float minimumBidIncrease;
    private ItemAuctionState itemAuctionState;

    private long startTimestamp;
    private long endTimestamp;

    public BidPlacementStatus record(Bid bid) {

        if(canPlaceBid(bid)) {
            bid.setBidPlacementStatus(BidPlacementStatus.ACCEPTED);
            this.winningBid = bid;
        } else {
            bid.setBidPlacementStatus(BidPlacementStatus.REJECTED);
        }
        this.bids.add(bid);

        return bid.getBidPlacementStatus();
    }


    private boolean canPlaceBid(Bid bid) {
        if(itemAuctionState == ACCEPTING_BID) {
            if(this.winningBid != null) { // there has been a previous winner
                return isLargerThanWinningBid(bid);
            } else {
                return true; // no previous winner so the bid is accepted
            }
        }
        return false;
    }

    private boolean isLargerThanWinningBid(Bid bid) {
        return bid.getAmount() > winningBid.getAmount() &&
                bid.getAmount() >= this.minimumBidIncrease + winningBid.getAmount();
    }


    public void start() {
        this.startTimestamp = System.currentTimeMillis();
        this.itemAuctionState = ACCEPTING_BID;
    }

    public void conclude() {
        this.endTimestamp = System.currentTimeMillis();
        if(winningBid.getAmount() >= reservedPrice) {
            this.itemAuctionState = CONCLUDED;
        } else {
            this.itemAuctionState = RESERVE_NOT_MET;
        }
    }

}
