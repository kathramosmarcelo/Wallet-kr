package com.kramomar.Wallet.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.kramomar.Wallet.util.Topic;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class KafkaProducer {
	

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

	
    public void sendNumberCardOriginToCard(String value) {
        kafkaTemplate.send(Topic.FIND_NUMBER_CARD_ORIGIN,value);
        logger.info("Messages successfully pushed on topic: " + Topic.FIND_NUMBER_CARD_ORIGIN);
    }
    public void sendNumberCardDestinationToCard(String value) {
        kafkaTemplate.send(Topic.FIND_NUMBER_CARD_DESTINATION,value);
        logger.info("Messages successfully pushed on topic: " + Topic.FIND_NUMBER_CARD_DESTINATION);
    }
}
