package com.ismail.tech.logisticsdelivery.services;

import com.ismail.tech.logisticsdelivery.data.model.OrderItem;
import com.ismail.tech.logisticsdelivery.data.repositories.OrderItemRepository;
import com.ismail.tech.logisticsdelivery.dtos.request.OrderItemDetailsRequest;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Data
@Service
public class OrderItemServiceImpl implements OrderItemService{
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void addOrder() {

    }

    @Override
    public void editOrder() {

    }

    @Override
    public void deleteOrder() {

    }

    @Override
    public void searchOrder() {

    }

    @Override
    public void placeOrder(OrderItemDetailsRequest orderDetailsRequest, String customerId) {
        OrderItem orderItem = new OrderItem();
        orderItem.setType(orderDetailsRequest.getType());
        orderItem.setDescription(orderDetailsRequest.getDescription());
        orderItem.setProductNumber(orderDetailsRequest.getProductNumber());
        orderItem.setCustomerId(customerId);
        orderItemRepository.save(orderItem);

    }
}
