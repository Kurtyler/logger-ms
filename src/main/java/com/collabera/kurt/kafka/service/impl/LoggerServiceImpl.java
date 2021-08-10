package com.collabera.kurt.kafka.service.impl;

import com.collabera.kurt.kafka.dto.response.LoggerResponse;
import com.collabera.kurt.kafka.entity.AuditLog;
import com.collabera.kurt.kafka.repository.AuditLogRepository;
import com.collabera.kurt.kafka.service.LoggerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoggerServiceImpl implements LoggerService {

    private final AuditLogRepository auditLogRepository;

    @Override
    public List<LoggerResponse> getAllLogs() {
        log.info("Fetching all logs ...");
        final List<AuditLog> auditLogs = auditLogRepository.findAll();
        final List<LoggerResponse> loggerResponses = new ArrayList<>();
        auditLogs.forEach(auditLog -> loggerResponses.add(new LoggerResponse(auditLog)));
        return loggerResponses;
    }
}
