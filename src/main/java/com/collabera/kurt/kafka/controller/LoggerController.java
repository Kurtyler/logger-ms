package com.collabera.kurt.kafka.controller;

import com.collabera.kurt.kafka.dto.response.LoggerResponse;
import com.collabera.kurt.kafka.service.LoggerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/logger")
public class LoggerController {

    private final LoggerService loggerService;

    @GetMapping("/getAllLogs")
    public ResponseEntity<List<LoggerResponse>> getAllLogs() {
        return ResponseEntity.status(HttpStatus.OK).body(loggerService.getAllLogs());
    }
}
