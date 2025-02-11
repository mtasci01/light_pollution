package com.mt.light_pollution.model;

import lombok.Data;


@Data
public class ReportDTO {
    private String mongoId;
    private Long createdAt;
    private Long fixedAt;
    private String city;
    private String country;
    private Double lat;
    private Double lon;
    private Integer severity;
    private String description;
}
