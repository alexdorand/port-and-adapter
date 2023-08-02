package org.example;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.driven.AuctionAdapter;
import org.example.driven.EventsAdapter;
import org.example.driven.FraudDetectionRestAdapter;
import org.example.usecase.PlaceBidUsecase;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan("org.example.driver")
public class DriverConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        objectMapper.configure(SerializationFeature.WRITE_SELF_REFERENCES_AS_NULL, false);
        return objectMapper;
    }


    @Bean
    public PlaceBidUsecase placeBidUsecase(EventsAdapter eventAdapter, AuctionAdapter auctionAdapter, FraudDetectionRestAdapter fraudDetectionRestAdapter) {
        return new PlaceBidUsecase(eventAdapter, auctionAdapter, fraudDetectionRestAdapter);
    }

    @Bean
    public AmazonSQS amazonSQS() {
        final AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
        return sqs;
    }

}
