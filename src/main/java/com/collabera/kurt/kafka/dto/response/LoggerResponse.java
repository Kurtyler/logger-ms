package com.collabera.kurt.kafka.dto.response;

import com.collabera.kurt.kafka.entity.AuditLog;
import lombok.*;

import static com.collabera.kurt.kafka.utility.DateUtility.formatDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoggerResponse {
    private Integer auditLogId;
    private String dateCreated;
    private String logDetails;

    public LoggerResponse(AuditLog auditLog) {
        this.auditLogId = auditLog.getAuditLogId();
        this.dateCreated = formatDate(auditLog.getDateCreated());
        this.logDetails = auditLog.getLogDetails();
    }
}
