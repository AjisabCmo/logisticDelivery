package com.ismail.tech.logisticsdelivery.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class ThirdPartyUser {
    private String id;
    private String name;
    private String homeAddress;
    private String  postalCode;
    private String state;
    private String country;
}
