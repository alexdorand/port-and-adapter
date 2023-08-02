package org.example.common.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
public class Event {

    private String id;
    private String type;
    private String identifier;

}
