package org.example.driven;

import lombok.extern.java.Log;
import org.example.common.Adaptor;
import org.example.port.driven.FraudDetectionPort;
import org.example.port.model.Bid;
import org.example.port.model.FraudDetectionResult;
import org.example.port.model.FraudProbability;

@Log
@Adaptor
public class FraudDetectionRestAdapter implements FraudDetectionPort {
    @Override
    public FraudDetectionResult detectFraud(Bid bid) {
        log.info("Detecting fraud for Bid with id "+bid.getId());
        FraudDetectionResult fraudDetectionResult = new FraudDetectionResult(null, FraudProbability.HIGHLY_LIKELY);
        log.info("No fraud was detected");
        return fraudDetectionResult;
    }
}
