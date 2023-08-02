package org.example.driver;


import jakarta.validation.Valid;
import org.example.driver.dto.BidPlacementRequest;
import org.example.driver.dto.BidPlacementResponse;
import org.example.port.driver.BidPlacementPort;
import org.example.port.model.Bid;
import org.example.port.model.BidPlacementStatus;
import org.example.usecase.PlaceBidUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.example.driver.RestAdapterFunctions.*;
import static org.example.driver.converter.BidPlacementConverter.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class BidPlacementApiGatewayAdapter implements BidPlacementPort {

    @Autowired
    private PlaceBidUsecase placeBidUsecase;


    @PostMapping(value = "/bid", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BidPlacementResponse> placeBid(@RequestBody @Valid BidPlacementRequest bidPlacementRequest) {

        BidPlacementStatus placeBidResult = placeBid(convertToBid(bidPlacementRequest), bidPlacementRequest.getItemId());
        BidPlacementResponse response = new BidPlacementResponse(placeBidResult);
        return new ResponseEntity<>(response, status.apply(placeBidResult));

    }

    @Override
    public BidPlacementStatus placeBid(Bid bid, String itemId) {
        return placeBidUsecase.placeBid(bid, itemId);
    }
}
