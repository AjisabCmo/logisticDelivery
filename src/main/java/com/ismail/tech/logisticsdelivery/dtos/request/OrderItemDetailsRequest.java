package com.ismail.tech.logisticsdelivery.dtos.request;

import lombok.Data;

@Data
public class OrderItemDetailsRequest {
    private String type;
    private String description;
    private String productNumber;
    private String customerName;
}
