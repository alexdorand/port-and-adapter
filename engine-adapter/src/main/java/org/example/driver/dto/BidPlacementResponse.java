package org.example.driver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.port.model.BidPlacementStatus;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BidPlacementResponse implements Serializable {
    BidPlacementStatus status;
}
