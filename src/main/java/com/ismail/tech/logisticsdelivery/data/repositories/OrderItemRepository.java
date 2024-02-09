package com.ismail.tech.logisticsdelivery.data.repositories;

import com.ismail.tech.logisticsdelivery.data.model.OrderItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderItemRepository extends MongoRepository<OrderItem, String> {
    OrderItem findOrderItemBy(String type);
}
