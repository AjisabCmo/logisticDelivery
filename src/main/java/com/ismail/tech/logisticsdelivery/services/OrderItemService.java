package com.ismail.tech.logisticsdelivery.services;

import com.ismail.tech.logisticsdelivery.dtos.request.OrderItemDetailsRequest;

public interface OrderItemService {
    void addOrder();
    void editOrder();
    void deleteOrder();
    void searchOrder();
    void placeOrder(OrderItemDetailsRequest orderDetailsRequest,String customerId);
}
