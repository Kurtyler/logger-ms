package com.collabera.kurt.kafka.service.impl;

import com.collabera.kurt.kafka.entity.AuditLog;
import com.collabera.kurt.kafka.repository.AuditLogRepository;
import com.collabera.kurt.kafka.service.KafkaConsumerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    private static final String TOPIC = "productTopics";
    private static final String GROUP_ID = "productTopicGroup";
    private static final String CONTAINER_FACTORY = "productKafkaListenerContainerFactory";

    private final AuditLogRepository auditLogRepository;

    /**
     * Kafka Consumer Service to listen on topic
     * @param message
     */
    @KafkaListener(topics = TOPIC,
            groupId = GROUP_ID,
            containerFactory = CONTAINER_FACTORY)
    @Override
    public void consumeProduct(final String message) {
        auditLogRepository.save(AuditLog.builder()
                .dateCreated(new Date())
                .logDetails(message).build());
        log.info("Consumed from {}, {}", TOPIC, message);
    }
}
