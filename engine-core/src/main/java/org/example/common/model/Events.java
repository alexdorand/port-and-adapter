package org.example.common.model;

import java.util.UUID;

public class Events {


    public static  Event FRAUD_DETECTED(String itemId) {
        return Event.builder()
                .id(UUID.randomUUID().toString())
                .type("FRAUD_DETECTED")
                .identifier(itemId)
                .build();
    }

    public static  Event BID_ACCEPTED(String itemId) {
        return Event.builder()
                .id(UUID.randomUUID().toString())
                .type("BID_ACCEPTED")
                .identifier(itemId)
                .build();
    }


}
