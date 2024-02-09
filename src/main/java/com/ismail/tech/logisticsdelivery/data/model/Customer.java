package com.ismail.tech.logisticsdelivery.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class Customer {
    private String id;
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String homeAddress;
    private String username;
    private String password;
    private boolean isLocked = true;


}
