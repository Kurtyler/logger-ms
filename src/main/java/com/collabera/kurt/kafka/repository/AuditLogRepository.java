package com.collabera.kurt.kafka.repository;

import com.collabera.kurt.kafka.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog, Integer> {
}
