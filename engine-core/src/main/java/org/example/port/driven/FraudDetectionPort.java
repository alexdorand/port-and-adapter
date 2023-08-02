package org.example.port.driven;

import org.example.port.model.Bid;
import org.example.port.model.FraudDetectionResult;

public interface FraudDetectionPort {
    FraudDetectionResult detectFraud(Bid bid);
}
