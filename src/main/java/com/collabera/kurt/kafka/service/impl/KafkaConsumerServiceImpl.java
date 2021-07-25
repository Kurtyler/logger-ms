package com.collabera.kurt.kafka.service.impl;

import com.collabera.kurt.kafka.entity.AuditLog;
import com.collabera.kurt.kafka.repository.AuditLogRepository;
import com.collabera.kurt.kafka.service.KafkaConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    private final AuditLogRepository auditLogRepository;

    public KafkaConsumerServiceImpl(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    @KafkaListener(topics = "productTopics",
            groupId = "productTopicGroup",
            containerFactory = "productKafkaListenerContainerFactory")
    @Override
    public void consumeProduct(String message) {
        auditLogRepository.save(AuditLog.builder()
        .dateCreated(new Date())
        .logDetails(message).build());
        log.info("Consumed Product, {}", message);
    }
}
