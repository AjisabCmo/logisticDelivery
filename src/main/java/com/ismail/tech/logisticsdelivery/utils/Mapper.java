package com.ismail.tech.logisticsdelivery.utils;

import com.ismail.tech.logisticsdelivery.data.model.Customer;
import com.ismail.tech.logisticsdelivery.dtos.request.RegisterRequest;

public class Mapper {
    public static Customer map(RegisterRequest registerRequest){
        Customer newCustomer = new Customer();
        newCustomer.setUsername(registerRequest.getUsername());
        newCustomer.setPassword(registerRequest.getPassword());
        return newCustomer;
    }
}
