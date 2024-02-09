package com.ismail.tech.logisticsdelivery.services;

import com.ismail.tech.logisticsdelivery.dtos.request.LoginRequest;
import com.ismail.tech.logisticsdelivery.dtos.request.OrderItemDetailsRequest;
import com.ismail.tech.logisticsdelivery.dtos.request.RegisterRequest;

public interface CustomerService {
    void register(RegisterRequest registerRequest);

    void login(LoginRequest loginRequest);

    void placeOrder(OrderItemDetailsRequest orderDetailsRequest);
    void placeOrderForAFriend();
}
