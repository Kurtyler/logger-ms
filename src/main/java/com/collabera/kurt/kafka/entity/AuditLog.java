package com.collabera.kurt.kafka.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity()
@Table(name = "AUDIT_LOGS")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUDIT_LOG_ID")
    private Integer auditLogId;

    @Column(name = "DATE_CREATED")
    private Date dateCreated;

    @Lob
    @Column(name = "LOG_DETAILS")
    private String logDetails;
}
