package com.collabera.kurt.kafka.service;

import com.collabera.kurt.kafka.dto.response.LoggerResponse;

import java.util.List;

public interface LoggerService {

    List<LoggerResponse> getAllLogs();
}
