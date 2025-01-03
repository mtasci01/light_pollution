package com.mt.light_pollution.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "reports")
public class ReportDoc {
    @Id
    private ObjectId id;
    private LocalDateTime createdAt;
    private LocalDateTime fixedAt;
    private Double lat;
    private Double lon;
    private String description;
}
