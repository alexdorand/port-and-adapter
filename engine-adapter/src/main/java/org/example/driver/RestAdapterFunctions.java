package org.example.driver;

import org.example.port.model.BidPlacementStatus;
import org.springframework.http.HttpStatus;

import java.util.function.Function;

public final class RestAdapterFunctions {

    public static final Function<BidPlacementStatus, HttpStatus> status = bidPlacementStatus -> {
        switch (bidPlacementStatus) {
            case REJECTED -> {
                return HttpStatus.BAD_REQUEST;
            }
            case ACCEPTED -> {
                return HttpStatus.OK;
            }
            default -> {
                return HttpStatus.NOT_ACCEPTABLE;
            }
        }
    };

}
